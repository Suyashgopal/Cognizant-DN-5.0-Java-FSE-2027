# Git & GitHub — Complete Notes

## 1. Basics

- **Git** = open-source software to track code over a timeline.
- **GitHub** = web platform that hosts Git repos.

### Installation
1. Install Git (the software).
2. `git --version` — verify install.
3. `git config --global user.name "..."`
4. `git config --global user.email "..."`

---

## 2. Core Commands

| # | Command | Purpose |
|---|---------|---------|
| 1 | `mkdir <name>` | Create a directory |
| 2 | `cd <name>` | Change directory |
| 3 | `git init` | Create a repo |
| 4 | `type nul > f.txt` | Make a new file |
| 5 | `notepad f.txt` | Edit it |
| 6 | `dir` | Check all files |
| 7 | `git status` | Show untracked files |
| 8 | `git add .` / `git add <file>` | Stage files |
| 9 | `git commit -m "msg"` | Commit staged changes |
| 10 | `git log` | Show commit history |

### Flow
```
git init
   │
   ▼
working dir ──[ git add . ]──► staging area
                                    │
                                    ▼
   repo ◄──────[ git commit ]──────┘
   │
   ▼
[ git push ] ──► GitHub
```

---

## 3. Internal Working of Git

### Git Snapshots
- History of all code saved in a **key–value** store.
- **Key** → unique hash code (string)
- **Value** → object

### 3 Parts
1. **Commit object** — each commit stored in the `.git` folder as a commit object.
2. **Tree object** — represents files / folders.
3. **Blob object** — the actual code.

```
┌─ Commit object ──────────┐      ┌─ Tree object ────────────┐
│ • Tree object ───────────┼────► │ • File name              │
│ • Parent commit object   │      │ • File type              │
│ • Author                 │      │ • File mode              │
│ • Committer              │      │ • Parent tree object     │
│ • Commit message         │      └──────────┬───────────────┘
└──────────────────────────┘                 │
                                              ▼
                                        ┌─ Blob ──────┐
                                        │ actual code │
                                        └─────────────┘
```

---

## 4. Branches

1. `git branch xyz` — create branch `xyz`.
2. `git branch` — show current branches.
3. `git checkout xyz` — switch to `xyz` branch.
4. `git merge xyz` — merge `xyz` into current branch.

---

## 5. Merging

### 1) Fast-Forward Merge (not diverged)
Main branch has **no commits** while the other branch does → **0 conflicts**. Easy merge.

```
main      (A)──(B)
                 \
feature1          (C)──(D)──(E)──► merge
```
*Main has no commits after feature branch creation → easy merge.*

```bash
git checkout main
git merge feature1
```

### 2) 3-Way Merge (diverged)
Same code base, **but conflicts exist** and you must resolve them.

```
main      (A)──(B)──(g)──(h)──(i)──(merge)
                 \                  /
feature1          (c)──(d)──(e)──(f)
```
*Conflicts arise because main has many commits not present in the feature branch.*

---

## 6. git diff

Compares changes between one commit and another. Git treats the same file as two files:
- Original file → `a/`
- Updated file → `b/`

Then compares:
```
---  → start of a/
+++  → start of b/
@@   → line no. & position of change
```

| Command | Meaning |
|---------|---------|
| `git diff --staged` | Last commit vs staged diff |
| `git diff <b1> <b2>` | Compare two branches |
| `git diff <commit1> <commit2>` | Diff between two commits (provide commit hash) |

---

## 7. git stash

Saves file changes in a **temporary location** — useful for saving work before switching branches.

> **Use case:** When conflicting changes don't allow switching branches before committing them, stash is the alternative. Current changes get saved in a temp location.

| Command | Action |
|---------|--------|
| `git stash` | Stash current changes |
| `git stash save "name"` | Named stash |
| `git stash list` | List the stashes |
| `git stash apply` | Apply most recent stash |
| `git stash apply s1` | Apply specific named stash |
| `git stash pop` | Apply **and** remove |
| `git stash clear` | Remove all |

---

## 8. Tags

| Command | Meaning |
|---------|---------|
| `git tag <name>` | Tag the commit |
| `git tag xyz` | Add name `xyz` to current commit |
| `git tag` | List all tags |
| `git tag <tag name> <commit hash>` | Tag a specific named commit |
| `git tag -d <tag name>` | Delete a tag |

---

## 9. Managing History

### Git Merge

**Before**
```
feature        (a)──(b)──(c)
                 /
main   (d)──(e)──(f)──(g)──(h)
```
```bash
git checkout main
git merge feature
```

**After**
```
feature        (a)──(b)──(c)
                 /          \
main  (d)─(e)─(f)─(g)─(h)──(merge)
                              └─ useless commit
```
→ Result: **dirty history**.

### Git Rebase

**Before**
```
feature              (a)──(b)──(c)
                       /
main   (d)──(e)──(f)──(g)──(h)
```
```bash
git checkout feature
git rebase main
```

1. **Temporarily removes** all feature commits and saves them aside:
   `(a) (b) (c)`  ·  base: `(d)─(e)─(f)─(g)─(h)`
2. **Replays** them after the last main commit:
```
main/feature  (d)─(e)─(f)─(g)─(h)─(a)─(b)─(c)
                                        └─ feature tip
```
→ Result: **clean, linear history**.

---

## 10. GitHub (Pushing a Repo)

1. Make a `.gitignore`:
   - `ni .gitignore`, **or** create it manually in the folder.
2. `git remote add origin "repo link"`
3. `git branch -m main` — rename branch to main.
4. `git push -u origin main`

### Remote & Upstream
- `git remote -v` — show remote URL of your local repo.
- `git push -u origin main` — **sets upstream**:
  - maps: `main ──► origin/main`
  - From next time just use `git push` or `git pull`.

---

## 11. Fetch vs Pull

### Fetch — download but **don't** update local files
```
GitHub:  A ─► B ─► C
Local:   A ─► B

Run:  git fetch origin

Now  in .git:  A ─► B ─► C
     Local:    A ─► B          (no code change)
```

### Pull — download **plus** update
```
git pull = git fetch + git merge

After pull:  Local = Remote
```
