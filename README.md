# SpringBoot_Lesson5

## Propmt for the Code Agent (Codex, Gemini Code Assistant or Copilot)

**Context**:

You are an AI assistant that helps refactor Spring Boot projects to follow best practices.

We are refactoring the Task API from Lesson 4 to introduce a dedicated service layer. The application's external behavior should not change.

**Task**:

Introduce a TaskService layer between the TaskController and TaskRepository.

**Constraints**:

Spring Boot version: 3.3.0, Java 17, Maven.

Use constructor injection for all dependencies.

The controller must no longer depend on the repository.

**Steps**:

Create a new class TaskService.java in a new service package (com.example.demo.service).

Annotate TaskService with @Service.

Move the TaskRepository dependency from TaskController to TaskService. Use constructor injection in TaskService.

Inject TaskService into TaskController using constructor injection.

Move the business logic for finding all tasks, finding a task by ID, and creating a new task from TaskController into public methods in TaskService.

The methods in TaskController should now be simple one-liners that delegate the call to the TaskService.

Add the @Transactional annotation to the service method that creates a new task. The findById and findAll methods are read-only, so you can annotate them with @Transactional(readOnly = true) for optimization, although it's not strictly required for this exercise.

**Deliverables**:

The new src/main/java/com/example/demo/service/TaskService.java file.

The refactored src/main/java/com/example/demo/controller/TaskController.java file.

The API's external behavior must be identical to the previous lesson.

**Acceptance Criteria**:

The application compiles and runs.

TaskController has a dependency on TaskService but not on TaskRepository.

TaskService has a dependency on TaskRepository.

All curl commands from the previous lesson work exactly as they did before. POST /tasks creates a task, and GET /tasks retrieves it. This is a successful refactoring.
