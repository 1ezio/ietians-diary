# IETian's Diary

![logo](https://ik.imagekit.io/jn4utpxjgdd/ietians-diary-with-bg_BQb1lS8zAsMr.png?updatedAt=1633057531914)

### An application for sharing educational resources <br><br>

## Table of content
- [What is Ietian's Diary](#what-is-ietians-diary)
- [Prerequisites](#prerequisites)
  - [Git & Github](#git-and-github)
  - [Android Studio](#android-studio)
- [How to contribute?](#how-to-contribute)
- [Contributors](#contributors)

## What is IETian's Diary

IETian's diary is a convenient application that allows students to share context-based resources
such as notes, previous year's exam papers, e-books, syllabus, assignments etc.

IETian's Diary was started by a group of IET students in their first year. Due to a lack of resources in their group at the time, they decided to create an app that would allow them to share resources such as previous year papers, study material such as books, notes, and assignments, among other things.
It was a huge hit with the student community at the time because nothing like it had ever been done before.
Students began using this app by sharing their resources with one another, and this is how IETian's diary came to be.

The application was working fine but progress is the law of nature,that is, many features of the application became obsolete and now it was the right time to upgrade.

> ## If we don't change, we don't grow, if we don't grow, we aren't really living!

<br>
Since the project was developed by students in their first year, the project code was not that maintainable and scalable so we decided to start from scratch.
<br>
<br>

## Prerequisites

### Git and Github

Here are some instructions on how to setup git. [![youtube-git](https://img.shields.io/badge/-Youtube-red?style=plastic&logo=youtube)](https://www.youtube.com/watch?v=uaeKhfhYE0U)

### Android Studio

Android Studio is the official Integrated Development Environment (IDE) for Android app development, based on IntelliJ IDEA . On top of IntelliJ's powerful code editor and developer tools, Android Studio offers even more features that enhance your productivity when building Android apps.
[![Learn more](https://img.shields.io/badge/-Learn%20more-orange?style=plastic)](https://developer.android.com/studio/intro)

# How to contribute

We're open to any kind of contribution, just follow the steps and you're good to go!

## Issues

- Submit a new [issue](https://github.com/1ezio/ietians-diary/issues/new/choose)
- Comment on an issue to get assigned

## Code Contribution (PR)

### Fork

- Fork the repository on your account
- If you're not sure, here's how to [fork](https://docs.github.com/en/get-started/quickstart/fork-a-repo) it

### Clone the fork

Clone the repository on your local machine using this command <br />
`$ git clone git@github.com:[your_github_handle]/ietians-diary.git && cd ietians-diary`
<br />
Or if you want to use the version control system of Android Studio, you can use your github account by generating a personal access token to login.
Here's how to generate a [Personal Access Token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)

### Create a temporary Firebase Project on your account

#### Creating Project

- Here's how to [create](https://codinglatte.com/posts/how-to/how-to-create-a-firebase-project/) one.
- After creating firebase project, create an android project inside it
- Generate SHA1 and SHA256 fingerprints and add to the project. Here's how to [do it](https://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode)
- Download the `google-services.json` file and place it inside the app folder (Project View)

#### Enabling Google Sign in

- Go to the authentication panel from the left menu
- Enable Google Sign in by clicking on it
- Copy the `web_client_id`

#### Handling keys/credentials inside the project

- Create a file named `keys.xml` inside the `values` directory under `src` -> `/app/src/values/keys.xml`
- Create a string resource item inside the file and name it `web_client_id`
- Paste the `web_client_id` you copied from Google Sign in
- It should look like this  
  `<string name="web_client_id">xxxxx-xxxxxxxx.apps.googleusercontent.com</string>`

#### Submitting Pull Request

- Open terminal/cmd and run these commands

  - `git checkout -B branch_name` create and checkout a new branch
  - `git add .` stage your changes
  - `git commit -m "your commit message"` commit your changes
  - `git push origin branch_name` push changes to github

- Go to your fork and click on the popup saying "Compare & Pull Request"
  ![compare&pull](https://user-images.githubusercontent.com/43697446/134040805-c114ccf9-aa14-427e-b01f-8dcb2f58ef94.png)

- Describe the issue you fixed and how you did it and click on make a PR.
- Wait for the reviewers to approve and merge it.

#### And that's it, you're done! We're looking forward to having wonderful contributors with us

### Here are some useful links you can refer to

#### [Figma Design File](https://www.figma.com/file/ZH1dsdzj2Fcwt3zrX6BQ5b/Ietian's-Diary)

#### [Figma Jam File](https://www.figma.com/file/oZBtdUazZWgcdvKsjUC90E/Ietians-Diary?node-id=0%3A1)

<br>

### Tech Stack

[![android](https://www.vectorlogo.zone/logos/android/android-icon.svg)](https://developer.android.com)
[![firebase](https://www.vectorlogo.zone/logos/firebase/firebase-ar21.svg)](https://firebase.google.com/)

### Contributors

<a href="https://github.com/1ezio/ietians-diary/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=1ezio/ietians-diary" />
</a>

Made with [contributors-img](https://contrib.rocks).
