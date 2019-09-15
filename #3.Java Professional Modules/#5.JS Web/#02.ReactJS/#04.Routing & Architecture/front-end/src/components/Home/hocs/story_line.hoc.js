import React, {Component} from 'react';

let storyLineHoc = (Comp) => {
    return class extends Component {
        constructor(props) {
            super(props);
            this.state = {
                showStoryLine: false,
                selectedStoryLineMovie: null,
            };

            this.onViewStoryLine = this.onViewStoryLine.bind(this);
        }

        onViewStoryLine(movie) {
            !this.state.showStoryLine ? this.setState({selectedStoryLineMovie: movie}) : this.setState({selectedStoryLineMovie: null});

            this.setState({showStoryLine: !this.state.showStoryLine})
        }

        render() {
            return (
                <Comp
                    onViewStoryLine={this.onViewStoryLine}
                    showStoryLine={this.state.showStoryLine}
                    selectedStoryLineMovie={this.state.selectedStoryLineMovie}
                    {...this.props}/>
            );
        }
    }
};

export default storyLineHoc;