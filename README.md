# Estrutura de folders

Um example de estrutura de folders para trabalhar com REST API.

```bash
├── src/main/java
│   ├── config
│   ├── exception
│   ├── converter
│   ├── integration
│   │   ├── client
│   │   ├── model
│   │   │   ├── dto
│   ├── model
│   │   ├── dto
│   │   ├── entity
│   │   ├── enumeration
│   ├── repository
│   ├── resource
│   ├── service
│   ├── util
├── src/main/resources
│   ├── application.yml
│   ├── messages
├── src/test/java
├── README.md
└── .gitignore
└── .editorconfig
```

Your app's source code is nested beneath the `app` directory. This is where assets are served from in `debug` mode. Note that in most cases it is not necessary to setup a watch to re-compile languages and syntaxes including CoffeeScript, Sass, Stylus, Jade, and LESS as the development server will automatically do this for you in middleware. Note that in your index page, you should not include the `/app` prefix since the development asset server will treat it as the root.
