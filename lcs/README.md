# Task for Connaxis

## Problem

Given 2 strings, find the longest common subsequence.

## Technology

Given the conversations so far along with Ethereum mostly Node and JavaScript technologies would be used. 
Hence the technology stack chosen for this task is:

* TypeScript (JavaScript)
* Node modules
* Angular4

## Structure

Folders (Node packages):
* `\task-logic`
    * Standalone Node module that has implementation for finding longest common substring for two strings. 
    * Possible Commands:
        * `npm test` - test
* `\task-web`
    * Sample driver app in Angular4. Generated using [Angular-CLI](https://github.com/angular/angular-cli).
    * Possible Commands:
        * `npm test` - test
        * `npm start` - serves the application locally
        * `npm build` - builds and packages for deployment

## Test environment

The application has been deployed to an Azure WebApp:

[http://temp-site.azurewebsites.net](http://temp-site.azurewebsites.net)

## Setup

### Development tools setup

1. Ensure you have Node and NPM installed.
2. Install tools (TypeScript compiler, Webpack bundler, LESS compiller, Angular4 CLI)
```
npm install -g typescript
npm install -g typings
npm install -g webpack
npm install -g less
npm install -g @angular/cli
npm install -g jasmine jasmine-ts
npm install -g chai ts-node
```

### Project setup

Restore Node packages and TS typings:
```
npm install
typings install
```

