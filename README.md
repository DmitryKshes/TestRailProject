# ✅ TestRail Java Automation Framework

> 📄 Этот документ описывает структуру, технологии и проверки компонентов фреймворка. Используется как справочник и контрольная точка качества.

---

## 🧰 Технологии и инструменты

- ☕ **Язык:** Java 17
- 🧪 **Тестовый фреймворк:** TestNG  
- 🌐 **WebDriver:** Selenium 
- 📦 **Dependency Management:** Maven
- 📋 **Отчёты:** Allure
- 📝 **Логирование:** Log4j2
- 🔄 **CI/CD:** GitHub Actions
- 🌍 **Браузеры:** Chrome & Mozilla
- 🧠 **Стиль проекта:** Page Object + API

---

## 📂 Структура фреймворка

```bash
src/
├── main/java         # Утилиты, ядро фреймворка
├── test/java         # Тесты и сценарии
├── resources/        # Конфигурации, данные
```

---

## 🧪 Чеклист проверок

### 🔐 1. Login

- [ ] Успешный вход с валидными данными
- [ ] Ошибка при невалидном пароле
- [ ] Ошибка при пустых полях
- [ ] Проверка редиректа после входа

---

### 🚪 2. Logout

- [ ] Успешный выход по кнопке "Выйти"
- [ ] Перенаправление на страницу входа

---

### 🧱 3. Создание проекта

- [ ] Создание проекта с валидными данными
- [ ] Валидация обязательных полей
- [ ] Отображение нового проекта в списке
- [ ] Обработка ошибок при создании (дубликат, пустое имя)
- [ ] Проверка, что проект создаётся в нужном workspace/контексте
- [ ] Редактирование проекта
- [ ] Удаление проекта с подтверждением

---

### 📝 4. Создание тест-кейса

- [ ] Создание с заполнением всех полей
- [ ] Проверка отображения кейса 
- [ ] Попытка создания без заполнения обязательных полей
- [ ] Экспорт/импорт тест-кейсов

---

### 🧪 5. Сбор прогона тест-кейсов

- [ ] Запуск одного тест-кейса вручную
- [ ] Запуск всех кейсов в проекте
- [ ] Проверка статуса выполнения (pass, fail, skipped)
- [ ] Проверка генерации отчёта
- [ ] Проверка отображения результата в истории прогона

---
