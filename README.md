# Poopee

What the Hack crazy App!

## Development

### Best practices

This project should be developed using the best practices listed below: 

- Clean architecture with 3 layers
    - Data (for models, database, API and preferences)
    - Domain (for business logic)
    - Presentation (for views and presenters)
- MVP pattern for Activities and Views
- [Dagger 2](https://google.github.io/dagger/) for dependency injection
- [Butterknife](https://jakewharton.github.io/butterknife/) for view injection
- [RxJava](https://github.com/ReactiveX/RxAndroid) for async tasks
- [Retrofit 2](https://github.com/square/retrofit) for API requests
- [Timber](https://github.com/JakeWharton/timber) for logging
- Project style guidelines based on [bufferapp/android-guidelines](https://github.com/bufferapp/android-guidelines/blob/master/project_style_guidelines.md)
- Code style based on [square/java-code-styles](https://github.com/square/java-code-styles)

### Workflow

1. Select a task from **ToDo** stack, tag yourself and move it to the **In Progress** stack.
1. Pull the **master** branch to get the last code modifications.
1. Create a branch from **master** for the task you are working on.
1. Code like a monkey! Add regular **commits** and **push** your code to the repository.
1. When the task is completed, create a new **Pull Request**.
1. Move your task to **Code Review** stack.
1. Someone else will **review** your code.
    1. If you receive a 👍  **merge** it away and **delete** the branch.
    1. Otherwise, fix it and ask the reviewer to check your changes.
1. Review any **Pull Requests** in the queue.
1. Eat, sleep, work and repeat!

Happy coding!
