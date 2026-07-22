import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMessage: ''
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to load posts from API.');
        }
        return response.json();
      })
      .then(data => {
        this.setState({ posts: data.slice(0, 10) });
      })
      .catch(error => {
        this.componentDidCatch(error, 'loadPosts Fetch Error');
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, errorInfo) {
    this.setState({ hasError: true, errorMessage: error.toString() });
    alert('Error caught in Posts component: ' + error.toString());
    console.error('componentDidCatch:', error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return (
        <div className="error-banner">
          <h2>An error occurred while loading posts.</h2>
          <p>{this.state.errorMessage}</p>
        </div>
      );
    }

    return (
      <section className="posts-wrapper">
        <h1 className="main-heading">Blog Posts Directory</h1>
        <div className="posts-grid">
          {this.state.posts.map(item => (
            <Post key={item.id} id={item.id} title={item.title} body={item.body} />
          ))}
        </div>
      </section>
    );
  }
}

export default Posts;
