<img src="imgs/gitTitle.png" width="450" height="250">

📖 **Git** es un sistema de control de versiones distribuido que permite **registrar**, **gestionar** y **recuperar** cambios en el código fuente de un proyecto a lo largo del tiempo.

- `Guarda` historial de cambios.
- `Permite` volver atrás si algo falla.
- `Facilita` trabajo en equipo sin pisarse el código.
- Usa ramas (branches) para `desarrollar` nuevas funciones sin romper lo estable.
  
---

## 🎋RAMAS

<img src="imgs/ramas1.png" width="450" height="250"  align="right">

Una rama (branch) es una línea de trabajo independiente que nace desde un punto del historial del proyecto y permite desarrollar cambios sin modificar la versión principal.
Una rama es una copia lógica del estado actual del proyecto donde puedes trabajar con libertad.

- Parte desde un `commit existente`
- Tiene su propio `historial`
- No `afecta` a otras ramas
- Puede `fusionarse` (merge) o `eliminarse`
  
---

## 😀 HEAD

**HEAD** es el puntero que indica el commit actual donde estás trabajando.
Marca tu posición en el historial.
```
main: A — B — C              A — B — C — D              feature: A — B — C — d — e               feature: A — b 
              ↑  — commit —>             ↑  — switch —>                          ↑  — reset —>                ↑
            HEAD                       HEAD                                    HEAD                         HEAD
```
--- 
## ⚡FASES Y ESTADOS DE GIT PARA HACER UN COMMIT

Git funciona como un sistema de 3 zonas por las que pasan tus archivos antes de guardarse definitivamente.

<img src="imgs/estados.png" width="450" height="250">

### 🟥 1. Working Directory (Modificado)

**Donde editas archivos:** `Cambias` código | `Creas/borras` ficheros | Git `detecta` cambios
  
### 🟧 2. Staging Area / Index (Preparado)

**Zona intermedia de selección:** Decides qué `cambios` entran al commit | No todo tiene que guardarse

```git
  git add .
  git add main.java
```
  
### 🟩 3. Repository (.git) (Confirmado)
**Historial permanente:** Se `crea` un commit | Queda `registrado` para siempre | Puedes `volver` a él cuando quieras

```git
  git commit -m "mensaje"
```

### 🟦 Remote Repository (Push)

**Servidor compartido** (ej: GitHub, GitLab): `publicas` tus commits | `sincronizas` con el equipo | `copia` de seguridad externa

```git
  git push
```
---

## ↩ REVERTIR ESTADOS

<img src="imgs/flowgit.png" width="450" height="250">

### 🟥 1. Working Directory (Modificado)

Cuando aún **no has hecho add**, pero has `modificado` el archivo de alguna manera: `borra` cambios locales | `vuelve` al último commit

```git
git restore archivo.java
git restore.
```

### 🟧 2. Staging Area (Preparado / Staged)

Cuando ya `hiciste add` y el archivo está listo para el commit: Lo `quita` del **staging** | `Vuelve` a estado **modificado** (no pierde cambios)

```git
git restore --staged archivo.java
git reset archivo.java
```

### 🟨 3. Local Repository (Commit)

##### ✏️ git commit --amend
    # Modifica/reescribe el último commit A — B — C → A — B — C'
    # Permite corregir mensaje o añadir archivos olvidados

##### 🔁 git reset --soft HEAD~1 
    # Deshace commit pero mantiene cambios staged: A — B — C → A — B (HEAD)
    # Hiciste commit demasiado pronto y quieres rehacerlo

##### 🧹 git reset --mixed HEAD~1        
    # Deshace commit y deja archivos modificados (NO staged): A — B — C → A — B (HEAD)
    # Limpia staging (Default)

##### 💣 git reset --hard HEAD~1         
    # Borra commit y cambios completamente (peligroso): A — B — C → A — B (HEAD)

### 🟩 4. Remote (Push)

**Cuando ya hiciste push y los cambios están en el servidor compartido:** Requiere cuidado porque afecta a otros | Se recomienda revertir, no borrar historia |
  
```git
git revert HEAD                 # crea commit inverso (seguro)
git push --force                # reescribe historial remoto (peligroso)
git pull                        # sincroniza antes de seguir trabajando
```

--- 


<img src="imgs/merge1.jpg" width="450" height="250"> 
<img src="imgs/merge2.png" width="450" height="250">
