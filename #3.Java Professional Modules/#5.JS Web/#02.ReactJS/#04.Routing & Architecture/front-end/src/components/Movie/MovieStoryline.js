import React, {Component, Fragment} from 'react';

class MovieStoryline extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Fragment>
                <span>
                    <h2>Story line of Avatar (2009)</h2>
                    <p>A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.</p>
                </span>
            </Fragment>
        );
    }

}

export default MovieStoryline;