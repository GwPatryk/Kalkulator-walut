Kalkulator walut

Program najpierw należy skompilować w wierszu polecenia cmd poleceniem:	javac GUI.java XmlParser.java Calculator.java
Następnie uruchomić poleceniem:	java GUI
Powinno pojawić się nieduże okienko programu składające się z czterech elementów:
- okna do wpisywania wartości pieniężnej w euro,
- rozwijanej listy walut znalezionych w pliku xml z walutami,
- przycisku "calculate" do przeliczania walut
- pola tekstowego przedstawiającego wyniki i informującego o niepoprawnym formacie wejściowej wartości liczbowej.

Korzystanie z kalkulatora polega na wpisaniu wartości pieniężnej w euro w białym polu tekstowym, które jest odporne na niepoprawne dane, takie jak litery lub spacje.
Poprawny format danych wejściowych to cyfry oddzielone kropką.
Po wpisaniu wartości należy wybrać z rozwijanej listy interesującą nas walutę, a następnie kliknąć zielony przycisk "calculate".
Wtedy na dole okienka pokaże nam się oczekiwany wynik.