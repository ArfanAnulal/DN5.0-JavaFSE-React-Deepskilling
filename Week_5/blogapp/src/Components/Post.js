import React, { Component } from 'react';

class Post extends Component {
  render() {
    const { title, body, id } = this.props;
    return (
      <article className="post-card">
        <span className="post-id">Post #{id}</span>
        <h3 className="post-title">{title}</h3>
        <p className="post-body">{body}</p>
      </article>
    );
  }
}

export default Post;
