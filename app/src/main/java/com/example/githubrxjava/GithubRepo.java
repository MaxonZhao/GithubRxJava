package com.example.githubrxjava;

public class GithubRepo {

    public final int id;
    public final String name;
    public final String htmlUrl;
    public final String description;
    public final String language;
    public final int stargezersCount;

    public GithubRepo(int id, String name, String htmlUrl, String description, String language, int stargezersCount) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.language = language;
        this.stargezersCount = stargezersCount;
    }
}
