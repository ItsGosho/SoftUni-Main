import React, {Component, Fragment} from 'react';

class MovieTrailer extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Fragment>
                <span>
                   <h2>Trailer of Titanic (1997)</h2>
                   <div className="trailer" style={{'width': '600px', 'height': '360px'}}>
                     <div style={{'width': '100%', 'height': '100%'}}>
                       <iframe frameBorder="0" allowFullScreen="1"
                               allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                               title="YouTube video player" style={{'width': '100%', 'height': '100%'}}
                               src="https://www.youtube.com/embed/ZQ6klONCq4s?autoplay=1&amp;mute=0&amp;controls=0&amp;origin=http%3A%2F%2Flocalhost%3A3000&amp;playsinline=1&amp;showinfo=0&amp;rel=0&amp;iv_load_policy=3&amp;modestbranding=1&amp;enablejsapi=1&amp;widgetid=1"
                               id="widget2">
                       </iframe>
                     </div>
                   </div>
                </span>
            </Fragment>
        );
    }

}

export default MovieTrailer;