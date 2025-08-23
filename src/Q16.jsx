import React, { Component } from "react";

//class component
class MovieForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",    //state variables
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: {          //platforms with checkboxes, default value given as false
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
      movies: [],      //array of movies to be updated
      showForm: true, // for componentWillUnmount demo
    };
    console.log("constructor executed");
  }

  /* Lifecycle: static */
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null;                                           // Runs before render, when props/state changes
  }

  componentDidMount() {
    console.log("componentDidMount executed");
  }                                                         //Runs only after the inital render

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true;                                            // Runs before re-rendering, always return true 
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {            //Runs before DOM is updated and return value to componentDidUpdate
    console.log("getSnapshotBeforeUpdate executed");
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {          //Runs after component updates
    console.log("componentDidUpdate executed");
  }

  componentWillUnmount() {                                       //Runs before component is removed from DOM
    console.log("componentWillUnmount executed");
  }


  //Arrow function taking e as argument
  handleChange = (e) => {                               //Event Handler for form input changes, it handles multiple inputs
    const { name, value, type, checked } = e.target;    //e.target takes input from the event
    if (type === "checkbox") {                          //checks wheather input is checbox or nor     
      this.setState((prevState) => ({                   //updates component state using setState
        platforms: { ...prevState.platforms, [name]: checked },
      }));
    } else {
      this.setState({ [name]: value });             //if didnt checked then just returns name
    }
  };

  //Arrow Function
  handleSubmit = (e) => {
    e.preventDefault();             //prevents it
    const { title, director, year, genre, rating, description, platforms } =            //object destructing
      this.state;

    const selectedPlatforms = Object.keys(platforms).filter(            //filters value which is true
      (key) => platforms[key]
    );

    const newMovie = {                          //new object
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: selectedPlatforms,
    };

    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie],        // spread operator for adding newMovie
      title: "",
      director: "",
      year: "",
      genre: "Action",          //Action as default
      rating: "",
      description: "",
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,              //all values are resets to default values
      },
    }));
  };

  toggleForm = () => {      
    this.setState((prev) => ({ showForm: !prev.showForm }));
  };

  render() {
    console.log("render executed");

    //unmount only if showform is true
    return (
      <div className="container mt-4">
        <button className="btn btn-warning mb-3" onClick={this.toggleForm}>         
          {this.state.showForm ? "Unmount Form" : "Mount Form"}                 
        </button>       


        {this.state.showForm && (       //conditional rendering
          <div className="card p-3 shadow">
            <h4 className="mb-3">Add Movie</h4>
            <form onSubmit={this.handleSubmit}>
              {/* Movie Title */}
              <div className="mb-2">
                <label className="form-label">Movie Title</label>
                <input
                  type="text"
                  name="title"
                  className="form-control"
                  value={this.state.title}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Director */}
              <div className="mb-2">
                <label className="form-label">Director</label>
                <input
                  type="text"
                  name="director"
                  className="form-control"
                  value={this.state.director}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Release Year */}
              <div className="mb-2">
                <label className="form-label">Release Year</label>
                <input
                  type="number"
                  name="year"
                  className="form-control"
                  value={this.state.year}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Genre */}
              <div className="mb-2">
                <label className="form-label">Genre</label>
                <select
                  name="genre"
                  className="form-select"
                  value={this.state.genre}
                  onChange={this.handleChange}
                >
                  <option>Action</option>
                  <option>Comedy</option>
                  <option>Drama</option>
                  <option>Sci-Fi</option>
                  <option>Horror</option>
                </select>
              </div>

              {/* Rating */}
              <div className="mb-2">
                <label className="form-label">Rating</label>
                <div>
                  {[1, 2, 3, 4, 5].map((num) => (
                    <label key={num} className="me-2">
                      <input
                        type="radio"
                        name="rating"
                        value={num}
                        checked={this.state.rating === String(num)}     //ensures only one is selected out of array of num
                        onChange={this.handleChange}
                      />{" "}
                      {num}
                    </label>
                  ))}
                </div>
              </div>

              {/* Description */}
              <div className="mb-2">
                <label className="form-label">Description</label>
                <textarea
                  name="description"
                  className="form-control"
                  value={this.state.description}
                  onChange={this.handleChange}
                />
              </div>

              {/* Platforms */}
              <div className="mb-2">
                <label className="form-label">
                  Available on Streaming Platforms
                </label>
                <div>
                  {Object.keys(this.state.platforms).map((platform) => (            //creates an array of all keys of platform names from platforms object and map iterates overall
                    <label key={platform} className="me-3">
                      <input
                        type="checkbox"
                        name={platform}
                        checked={this.state.platforms[platform]}
                        onChange={this.handleChange}
                      />{" "}
                      {platform}
                    </label>
                  ))}
                </div>
              </div>

              <button type="submit" className="btn btn-primary mt-2">
                Add Movie
              </button>
            </form>
          </div>
        )}

        {/* Display Movies in the Table*/}
        {this.state.movies.length > 0 && (          //renders only if length over 0
          <div className="mt-4">
            <h4>Movie List</h4>
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Description</th>
                  <th>Platforms</th>
                </tr>
              </thead>
              <tbody>
                {this.state.movies.map((movie, idx) => (
                  <tr key={idx}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.year}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>{movie.description}</td>
                    <td>{movie.platforms.join(", ")}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MovieForm;
