import React from 'react';

let ContactDetails = () => {
    return (
        <div className="container">
            <div className="info">
                <div className="col">
                    <span className="avatar">&#9787;</span>
                </div>
                <div className="col">
                    <span className="name">Ivan</span>
                    <span className="name">Ivanov</span>
                </div>
            </div>
            <div className="info">
                <span className="info-line">&phone; 0887 123 456</span>
                <span className="info-line">&#9993; i.ivanov@gmail.com</span>
            </div>
        </div>
    );
};

export default ContactDetails;