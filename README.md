# comp-java-emailvalidator

![build](https://github.com/alexandrkakushin/comp-java-emailvalidator/workflows/build/badge.svg)

Java-компонента "E-mail валидатор"

Компонента для проверки валидности электронной почты
Методы:
 1) Фунцкия ЭтоВалидный(АдресЭП, ДоменВторогоУровня = Истина, ОписаниеОшибки = Неопределено)

## Установка

Компонента устанавливается/обновляется интерактивно, для этого в справочнике "Компоненты Java" размещены соответствующие команды.

Ниже приведен пример подключения компоненты

``` 1С:Enterprise

///////////////////////////////////////////////////////////////////////////////
// Компоненты

#Область Компоненты

// "Объект" EMailValidator
// 
// Возвращаемое значение:
//  Обработка - Объект метаданных
//
Функция EMailВалидатор() Экспорт
	
	Возврат ИнтерфейсКомпоненты("comp-java-emailvalidator");
	
КонецФункции

#КонецОбласти

Функция ИнтерфейсКомпоненты(Репозиторий)
	
	Компонента = КомпонентыJava.КомпонентаПоРепозиторию(Репозиторий);
	Если Не ЗначениеЗаполнено(Компонента) Тогда
		ОписаниеОшибки = Неопределено;
		Если Не КомпонентыJava.УстановитьКомпоненту(Репозиторий, ОписаниеОшибки) Тогда
			ВызватьИсключение ОписаниеОшибки;			
		КонецЕсли;
				
		Компонента = КомпонентыJava.КомпонентаПоРепозиторию(Репозиторий);
	КонецЕсли;
	
	Возврат КомпонентыJava.Интерфейс(Компонента);	
	
КонецФункции
```

В дальнейшем для получения функционала "Email-валидатор" достаточно реализовать вызов 

``` 1С:Enterprise
Функция EmailВалиден(АдресЭП, ОписаниеОшибки = Неопределено) Экспорт
	
	Если НЕ ЗначениеЗаполнено(АдресЭП) Тогда
		Возврат Истина;
	КонецЕсли;
		
	Результат = Ложь;
		
	EMailВалидатор = КомпонентыJavaAPI.EMailВалидатор();  
	ВалидностьАдреса = EMailВалидатор.ЭтоВалидный(АдресЭП, Истина, ОписаниеОшибки);
	Если ВалидностьАдреса <> Неопределено Тогда
		Результат = ВалидностьАдреса;
	КонецЕсли;
	
	Возврат Результат;
	
КонецФункции
```
