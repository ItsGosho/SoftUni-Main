import React, {Component} from 'react';

let trailerHoc = (Comp) => {
    return class extends Component {
        constructor(props) {
            super(props);
            this.state = {
                showTrailer: false,
                selectedTrailerMovie: null,
            };

            this.onViewTrailer = this.onViewTrailer.bind(this);
        }

        onViewTrailer(movie) {
            !this.state.showTrailer ? this.setState({selectedTrailerMovie: movie}) : this.setState({selectedTrailerMovie: null});
            this.setState({showTrailer: !this.state.showTrailer})
        }

        render() {
            return (
                <Comp
                    onViewTrailer={this.onViewTrailer}
                    showTrailer={this.state.showTrailer}
                    selectedTrailerMovie={this.state.selectedTrailerMovie}
                    {...this.props}/>
            );
        }
    }
};

export default trailerHoc;