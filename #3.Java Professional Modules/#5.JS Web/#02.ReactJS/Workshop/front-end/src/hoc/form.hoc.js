import React, {Component} from 'react';

let Form = (Comp) => {
    return class extends Component {

        constructor(props) {
            super(props);
            this.state = {};

            this.onFormChange = this.onFormChange.bind(this);
        }

        onFormChange(event) {
            let inputName = event.target.name;
            let value = event.target.value;

            this.setState({[inputName]: value});
            event.preventDefault();
        }

        render() {
            return (
                <Comp
                    onFormChange = {this.onFormChange}
                    formData={this.state}
                    {...this.props}/>
            );
        }
    }
};

export default Form;