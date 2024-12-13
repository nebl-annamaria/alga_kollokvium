## Algoritmusok és adatszerkezetek gyakorlat beadandó feladat

### Nébl Annamária, Neptun: K04POD

### Kollokvium feladat: SPOJ

Link a feladathoz:
[MCARDS - Card Sorting](https://www.spoj.com/problems/MCARDS/)

tesztfileok a projektbe csatolva unit tesztekként

## Feladat:
A feladat a kártyák csoportba rendezése. 
Minden csoportban azonos színű kártyáknak kell lennie.
Ezek után a csoportokon belül érték szerint 
növekvő sorrendbe kell rendezni a kártyákat.
Mindvégig az összes kártyának a kezében kell lennie.
A feladat kiszámolni, hogy legkevesebb hány mozdulattal
érhető el a kívánt rendezés.
## Input:

A bemenet első sora két számot tartalmaz.
Az első C szám adja meg, hogy hány féle színű kártya létezik.
A második N szám adja meg, hogy minden színből hány darab kártya van.

A következő CxN db sorban 2 db egész szám van szóközzel elválasztva: X és Y. 

X jelenti a leosztott kártya színét, Y pedig a darabszámot.

## Algoritmus:
dinamikus programozás

## Kivitelezés:

- beolvassuk a kártyák számát és minden színből lévő kártyák számát
- beolvassuk a kártyák színét és értékét, és ezeket egy listába mentjük
- elkészítjük a színek listáját
- kigeneráljuk a színek minden lehetséges sorrendjét
- minden permutáció esetén meghatározzuk, hogy az adott sorrendben a kártyákat hogyan kellene elhelyezni
- kiszámítjuk a hosszú növekvő részsorozat hosszát az adott sorrend szerint
- a hosszú növekvő részsorozat hossza alapján megállapítjuk, hány kártyát kell minimálisan áthelyezni
- eltároljuk a legkisebb szükséges áthelyezési számot
- a permutációk végigpróbálása után kiírjuk a legkisebb áthelyezési számot  
