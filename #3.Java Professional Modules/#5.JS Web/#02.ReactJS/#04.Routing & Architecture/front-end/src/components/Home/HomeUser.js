import React, {Component, Fragment} from 'react';

class HomeUser extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Fragment>
                <li className="movie">
                    <h2>Titanic (1997)</h2>
                    <img src="https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX182_CR0,0,182,268_AL_.jpg"/>
                    <span>
                        <button>View Trailer</button>
                        <button>View Story Line</button>
                    </span>
                </li>
            </Fragment>
        );
    }

}

export default HomeUser;