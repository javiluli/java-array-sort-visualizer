# Ordenacion visual de un Array en Java

Disponibles hasta 22 algoritmos de ordenacion y 6 variantes para el diseño grafico.

La carpeta _data/_ almacena archivos como videos e imagenes que afectan visualmente, no son imprescindibles para el funcionamiento del programa. Para su uso correcto se debe dejar de la misma forma en la que se decarga el repositorio, en una misma carpeta o directorio:

- ordenacionVisual.jar
- data/

## Descarga

```
git clone https://github.com/javiluli/Ordenacion-visual-Java.git
```

---

## Generar ejecutable

```
mkdir -p dist target
javac src/Principal/MainAplicacion.java -sourcepath src -d target/
jar -cvfm dist/ordenacionVisual.jar manifest.mf -C target/ ./
```

---

## Iniciar aplicacion

```
java -jar dist//ordenacionVisual.jar
```

## Disponibles 22 tipos de algoritmos.

- Bitonic sort
- [Bubble sort](https://youtu.be/XaJzmQhKbsM)
- [Optimized bubble sort](https://youtu.be/M5o90Ca8kqM)
- [Cocktail sort](https://youtu.be/x_2L2QLYZR4)
- [Cycle sort](https://youtu.be/v_hKwLFV5Ck)
- [Gnome sort](https://youtu.be/JnEOrhdxe1w)
- [Heap sort](https://youtu.be/IYgJceePT5w)
- [Insertion sort](https://youtu.be/Hfh56tGWVV4)
- Iterative Quick sort
- Merge sort
- Odd Even sort
- Pancake sort
- Pigeonhole sort
- Quick sort
- Radix sort
- Recursive Bubble sort
- Recursive Insertion sort
- Recursive Selection sort
- Selection sort
- Shell sort
- Stooge sort
- Tim sort

## Disponibles 6 diseños graficos distintos.

- Escalera
- Piramide horizontal
- Pixel
- Circulo
- Circunferencia
- Espiral

La carpeta _data/_ almacena archivos como videos e imagenes que afectan visualmente, no son necesarios para el funcionamiento del programa. Para su uso correcto se debe dejar de la misma forma en la que se decarga el repositorio, en una misma carpeta o directorio:

- ordenacionVisual.jar
- data/

### Bubble optimized Sort

![bubble_optimized.gif](data/media/video/bubble_optimized.gif)

---

### Merge Sort

![merge.gif](data/media/video/merge.gif)

---

### Radix LSD Sort

![radix_lsd.gif](data/media/video/radix_lsd.gif)

---
