# Ordenacion visual en Java

Aplicacion a nivel basico para visualizar de forma grafica la ordenacion de un Array con diferentes algoritmos.

La carpeta _data/_ almacena archivos como videos e imagenes que afectan visualmente, no son imprescindibles para el funcionamiento del programa. Para su uso correcto se debe dejar de la misma forma en la que se decarga el repositorio, en una misma carpeta o directorio:

- ordenacionVisual.jar
- data/
<!--

## Descargar e iniciar aplicacion.

````
git clone https://github.com/javiluli/Ordenacion-visual-Java.git
cd Ordenacion-visual-Java/
mkdir -p dist target
javac src/Principal/MainAplicacion.java -sourcepath src -d target/
jar -cvfm dist/MainAplicacion.jar manifest.mf -C target/ ./
java -jar dist//MainAplicacion.jar
``` -->

## Algoritmos utilizados.

- Bubble
- Bubble Optimized
- Cocktail
- Cycle
- Gnome
- Heap
- Insertion
- Merge
- Odd Even
- Pancake
- Pigeonhole
- Quick
- Radix LSD (base 4)
- Selection
- Shell

### Bubble optimized Sort

![bubble_optimized.gif](data/media/video/bubble_optimized.gif)

---

### Merge Sort

![merge.gif](data/media/video/merge.gif)

---

### Radix LSD Sort

![radix_lsd.gif](data/media/video/radix_lsd.gif)

---
````
