package com.example.githubrxjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

public class GithubRepoAdapter extends BaseAdapter {
    private List<GithubRepo> githubRepos = new ArrayList<>();

    @Override
    public int getCount() {
        return githubRepos.size();
    }

    @Override
    public GithubRepo getItem(int position) {
        if (position < 0 || position >= githubRepos.size()) {
            return null;
        } else {
            return githubRepos.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView != null ? convertView : createView(parent));
        final GithubRepoViewHolder viewHolder = (GithubRepoViewHolder) view.getTag();
        viewHolder.setGithubRepo(getItem(position));
        return view;
    }

    public void setGithubRepos(@Nullable List<GithubRepo> repos) {
        if (repos == null) {
            return;
        }
        githubRepos.clear();
        githubRepos.addAll(repos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        final GithubRepoViewHolder viewHolder = new GithubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    private static class GithubRepoViewHolder {
        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public GithubRepoViewHolder(View view) {
            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGithubRepo(GithubRepo githubRepo) {
            textRepoName.setText(githubRepo.name);
            textRepoDescription.setText(githubRepo.description);
            textLanguage.setText("Language: " + githubRepo.language);
            textStars.setText("Stars: " + githubRepo.stargezersCount);
        }
    }
}
