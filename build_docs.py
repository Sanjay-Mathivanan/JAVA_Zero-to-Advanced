import os
import shutil
import re
import yaml

# Configurations
SOURCE_DIR = "."
DOCS_DIR = "docs"
TEMPLATE_FILE = "mkdocs.template.yml"
OUTPUT_CONFIG = "mkdocs.yml"

EXCLUDE_DIRS = {
    "docs", "site", "venv", ".venv", ".git", ".github", ".gemini", ".agents",
    "assets", "__pycache__"
}

def format_title(filename):
    if filename == "index.md":
        return "Overview"
    name = os.path.splitext(filename)[0]
    if "_" in name and name.split("_")[0].isdigit():
        name = name.split("_", 1)[1]
    elif "-" in name and name.split("-")[0].isdigit():
        name = name.split("-", 1)[1]
        
    name = name.replace("-", " ").replace("_", " ")
    words = name.split()
    formatted_words = []
    for word in words:
        if word.lower() in ("oops", "oop"):
            formatted_words.append("OOP")
        elif word.lower() in ("jcf", "jvm", "jre", "jdk", "fifo", "lifo", "cli", "ide"):
            formatted_words.append(word.upper())
        else:
            formatted_words.append(word.capitalize())
    return " ".join(formatted_words)

def format_folder_title(foldername):
    name = foldername
    if "_" in name and name.split("_")[0].isdigit():
        name = name.split("_", 1)[1]
    elif "-" in name and name.split("-")[0].isdigit():
        name = name.split("-", 1)[1]
        
    name = name.replace("-", " ").replace("_", " ")
    words = name.split()
    formatted_words = []
    for word in words:
        if word.lower() in ("oops", "oop"):
            formatted_words.append("OOP")
        elif word.lower() in ("jcf", "jvm", "jre", "jdk", "fifo", "lifo", "cli", "ide"):
            formatted_words.append(word.upper())
        else:
            formatted_words.append(word.capitalize())
    return " ".join(formatted_words)

def clean_docs_dir():
    if os.path.exists(DOCS_DIR):
        shutil.rmtree(DOCS_DIR)
    os.makedirs(DOCS_DIR)

def copy_assets():
    src_assets = os.path.join(SOURCE_DIR, "assets")
    dest_assets = os.path.join(DOCS_DIR, "assets")
    if os.path.exists(src_assets):
        shutil.copytree(src_assets, dest_assets)

def fix_markdown_links(content):
    def repl(match):
        text = match.group(1)
        target = match.group(2)
        
        # Rewrite the target link
        if "README.md" in target:
            target = target.replace("README.md", "index.md")
        else:
            # Check if target is a folder link (lacks an extension in the last segment)
            base_target = target.split("#")[0]
            if base_target:
                clean_target = base_target.strip("/")
                last_segment = clean_target.split("/")[-1] if clean_target else ""
                if last_segment and "." not in last_segment:
                    if target.endswith("/"):
                        target = target + "index.md"
                    else:
                        if "#" in target:
                            parts = target.split("#", 1)
                            target = parts[0] + "/index.md#" + parts[1]
                        else:
                            target = target + "/index.md"
            
        return f"[{text}]({target})"
        
    return re.sub(r'\[([^\]]+)\]\(([^)]+)\)', repl, content)

def copy_and_process_file(src, dest):
    os.makedirs(os.path.dirname(dest), exist_ok=True)
    with open(src, "r", encoding="utf-8") as f:
        content = f.read()
    
    # Process markdown links
    processed_content = fix_markdown_links(content)
    
    with open(dest, "w", encoding="utf-8") as f:
        f.write(processed_content)

def copy_markdown_files():
    # Copy root README.md to docs/index.md as the homepage
    root_readme = os.path.join(SOURCE_DIR, "README.md")
    if os.path.exists(root_readme):
        copy_and_process_file(root_readme, os.path.join(DOCS_DIR, "index.md"))
        
    for root, dirs, files in os.walk(SOURCE_DIR):
        # Filter directories in-place to exclude hidden and ignored folders
        dirs[:] = [d for d in dirs if d not in EXCLUDE_DIRS and not d.startswith(".")]
        
        for file in files:
            if file.endswith(".md") and file != "README.md":
                rel_path = os.path.relpath(os.path.join(root, file), SOURCE_DIR)
                dest_path = os.path.join(DOCS_DIR, rel_path)
                copy_and_process_file(os.path.join(root, file), dest_path)
            elif file == "README.md" and root != SOURCE_DIR:
                rel_path = os.path.relpath(os.path.join(root, "index.md"), SOURCE_DIR)
                dest_path = os.path.join(DOCS_DIR, rel_path)
                copy_and_process_file(os.path.join(root, file), dest_path)

def create_missing_index_files():
    for root, dirs, files in os.walk(DOCS_DIR):
        if "index.md" not in files and root != DOCS_DIR:
            # Check if this folder has any subfolders containing index.md or md files
            valid_subdirs = []
            for d in dirs:
                sub_path = os.path.join(root, d)
                has_md = False
                for r, _, fs in os.walk(sub_path):
                    if any(f.endswith(".md") for f in fs):
                        has_md = True
                        break
                if has_md:
                    valid_subdirs.append(d)
            
            # Generate missing index landing pages
            if valid_subdirs:
                folder_name = os.path.basename(root)
                title = format_folder_title(folder_name)
                
                content = f"# {title}\n\n"
                content += "Select a sub-topic to continue:\n\n"
                
                valid_subdirs.sort()
                for d in valid_subdirs:
                    sub_title = format_folder_title(d)
                    content += f"* [{sub_title}]({d}/index.md)\n"
                
                index_path = os.path.join(root, "index.md")
                with open(index_path, "w", encoding="utf-8") as f:
                    f.write(content)
                print(f"Generated missing landing page: {index_path}")

def generate_nav():
    def get_nav_for_dir(current_dir):
        items = []
        entries = os.listdir(current_dir)
        
        files = []
        folders = []
        for entry in entries:
            full_path = os.path.join(current_dir, entry)
            if os.path.isdir(full_path):
                if entry != "assets":
                    folders.append(entry)
            elif entry.endswith(".md"):
                files.append(entry)
                
        folders.sort()
        files.sort()
        if "index.md" in files:
            files.remove("index.md")
            files.insert(0, "index.md")
            
        for file in files:
            title = format_title(file)
            rel_path = os.path.relpath(os.path.join(current_dir, file), DOCS_DIR).replace("\\", "/")
            items.append({title: rel_path})
            
        for folder in folders:
            folder_title = format_folder_title(folder)
            sub_nav = get_nav_for_dir(os.path.join(current_dir, folder))
            if sub_nav:
                items.append({folder_title: sub_nav})
                
        return items

    nav = []
    if os.path.exists(os.path.join(DOCS_DIR, "index.md")):
        nav.append({"Home": "index.md"})
        
    entries = sorted(os.listdir(DOCS_DIR))
    for entry in entries:
        full_path = os.path.join(DOCS_DIR, entry)
        if os.path.isdir(full_path) and entry != "assets":
            folder_title = format_folder_title(entry)
            sub_nav = get_nav_for_dir(full_path)
            if sub_nav:
                nav.append({folder_title: sub_nav})
                
    return nav

def build_config(nav):
    if not os.path.exists(TEMPLATE_FILE):
        raise FileNotFoundError(f"Template config file {TEMPLATE_FILE} not found!")
        
    with open(TEMPLATE_FILE, "r", encoding="utf-8") as f:
        template_content = f.read()
        
    nav_yaml = yaml.safe_dump({"nav": nav}, default_flow_style=False, allow_unicode=True, sort_keys=False)
    
    with open(OUTPUT_CONFIG, "w", encoding="utf-8") as f:
        f.write(template_content)
        f.write("\n\n")
        f.write(nav_yaml)
        
    print(f"Generated {OUTPUT_CONFIG} with {len(nav)} top-level navigation items.")

if __name__ == "__main__":
    print("Preparing docs directory...")
    clean_docs_dir()
    copy_assets()
    copy_markdown_files()
    print("Validating directory landing pages...")
    create_missing_index_files()
    print("Generating navigation...")
    nav = generate_nav()
    build_config(nav)
    print("Workspace configuration compiled successfully!")
