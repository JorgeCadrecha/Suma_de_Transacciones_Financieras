# Suma_de_Transacciones_Financieras


## Contexto: 
Eres un desarrollador de software en una gran corporación con múltiples departamentos como informática, gerencia, contabilidad, comercio y recursos humanos. Cada departamento realiza varias transacciones financieras diarias, y todas estas transacciones se registran y almacenan en archivos de texto individuales correspondientes a cada departamento.

Dado el volumen de transacciones, la empresa necesita una forma eficiente de procesar y sumar todas las transacciones de cada departamento. Sin embargo, dado que los archivos se actualizan constantemente a lo largo del día, no es posible realizar este procesamiento de forma secuencial, ya que llevaría demasiado tiempo.

Para abordar este desafío, la empresa te ha pedido que desarrolles un programa que pueda procesar y sumar las transacciones de cada archivo de manera concurrente, utilizando el paralelismo de la máquina.

Además, para facilitar la revisión y el análisis posterior, el programa debe generar un archivo de resultados para cada departamento, que contendrá la suma total de las transacciones del respectivo departamento. Por ejemplo, los resultados para el archivo "informatica.txt" se almacenarán en "informatica.txt.res".

Finalmente, para tener una visión completa de las transacciones de toda la empresa, el programa debe sumar todas las sumas de cada departamento y guardar el total en un archivo llamado "Resultado_global.txt".

Debido a la posible magnitud de las transacciones, debes utilizar el tipo de dato long. Además, tu programa debe manejar correctamente las posibles excepciones, como los errores de entrada/salida.

Para organizar tu trabajo, puedes considerar la creación de las siguientes clases:

1. UtilidadesFicheros: con métodos útiles para el procesamiento de archivos, incluyendo uno para obtener la suma de las transacciones de un conjunto de archivos.
2. ProcesadorContabilidad: que procesará un archivo, sumará las transacciones y almacenará el resultado en el archivo correspondiente.
3. Lanzador: que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.

Tu programa consistirá en varias clases que pueden estar dispersas en diferentes directorios, por lo que tu método main necesitará tomar el CLASSPATH de los argumentos.

Al final del proyecto, debes entregar el código fuente de tu programa, incluyendo todas las clases necesarias. Esto permitirá a la empresa procesar sus transacciones de manera eficiente, ahorrando tiempo y recursos.

### Rúbrica para Evaluar el Proyecto de Procesamiento Concurrente y Suma de Transacciones Financieras de Departamentos

#### 1. Funcionalidad y Correctitud (40 puntos)

- El programa procesa y suma las transacciones de cada archivo correctamente (10 puntos).
- El programa genera correctamente los archivos de resultados con las sumas de las transacciones para cada archivo de entrada (10 puntos).
- El programa suma correctamente las sumas de cada archivo de resultados y guarda el total en "Resultado_global.txt" (10 puntos).
- El programa maneja correctamente las excepciones, especialmente los errores de entrada/salida (10 puntos).

#### 2. Concurrencia y Paralelismo (20 puntos)

- El programa aprovecha adecuadamente la concurrencia y el paralelismo para procesar los archivos (10 puntos).
- El programa gestiona correctamente la sincronización entre los hilos, evitando condiciones de carrera y bloqueos (10 puntos).

#### 3. Diseño del Código y Estructura (20 puntos)

- Las clases y métodos están bien organizados y siguen los principios de la programación orientada a objetos (10 puntos).
- El código está limpio, bien comentado y fácil de entender y mantener (10 puntos).

#### 4. Pruebas y Robustez (20 puntos)

- El programa funciona correctamente con varios conjuntos de datos de prueba, incluyendo casos límite (10 puntos).
- El programa es robusto y puede manejar entradas inesperadas y errores de manera elegante (10 puntos).

Cada criterio se calificará de acuerdo con el siguiente sistema de puntuación:

- Incompleto / Incorrecto (0 puntos): El código no cumple con el criterio, o la implementación es incorrecta.
- Parcialmente Completo (puntos parciales): El código cumple parcialmente con el criterio, pero hay algunos errores o aspectos que podrían mejorarse.
- Completo / Correcto (puntos completos): El código cumple completamente con el criterio y está implementado correctamente.

Nota: Dependiendo de las políticas de evaluación de su institución o instructor, puede ajustar la rúbrica para dar mayor o menor peso a los diferentes criterios.

