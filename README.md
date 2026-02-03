---
layout: page
title: Cryptography - CS-6343
subtitle: Spring 2026
permalink: /
---

<div class="course-header">
  <h1>Cryptography (CS-6343)</h1>
  <p class="course-meta">Spring 2026 • Texas Tech University</p>
</div>

## Course Overview

Advanced study of cryptographic systems, security protocols, and modern encryption techniques including symmetric/asymmetric encryption, hash functions, digital signatures, and public key cryptography.

## Quick Navigation

<div class="nav-grid">
  <div class="nav-card">
    <h3>📚 Lectures</h3>
    <p>Course materials, slides, and lecture notes</p>
    <a href="/lectures/">View Lectures</a>
  </div>
  
  <div class="nav-card">
    <h3>📝 Assignments</h3>
    <p>Homework, projects, and evaluations</p>
    <a href="/assignments/">View Assignments</a>
  </div>
  
  <div class="nav-card">
    <h3>🔬 Projects</h3>
    <p>Implementation projects and case studies</p>
    <a href="/projects/">View Projects</a>
  </div>
  
  <div class="nav-card">
    <h3>📖 Resources</h3>
    <p>Additional materials and references</p>
    <a href="/resources/">View Resources</a>
  </div>
</div>

## Course Information

| Item | Details |
|------|---------|
| **Course Number** | CS-6343 |
| **Semester** | Spring 2026 |
| **Canvas** | [Course Page](https://texastech.instructure.com/courses/70714) |
| **Main Site** | [scottweeden.online](https://scottweeden.online) |

## Recent Updates

{% assign posts = site.posts | limit: 3 %}
{% if posts.size > 0 %}
<div class="recent-posts">
  <h3>Recent Posts</h3>
  {% for post in posts %}
    <div class="post-preview">
      <h4><a href="{{ post.url | relative_url }}">{{ post.title }}</a></h4>
      <time datetime="{{ post.date | date_to_xmlschema }}">{{ post.date | date: "%B %-d, %Y" }}</time>
    </div>
  {% endfor %}
</div>
{% endif %}

---

<div class="course-footer">
  <p>← <a href="https://scottweeden.online">Back to Main Site</a></p>
</div>