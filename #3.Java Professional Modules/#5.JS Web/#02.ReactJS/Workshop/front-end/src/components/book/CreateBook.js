import React, {Component} from 'react';
import Form from "../../hoc/form.hoc";

class CreateBook extends Component {

    render() {
        let {onFormChange} = this.props;

        return (
            <div className="form-wrapper">
                <h1>Create New Book</h1>
                <form>
                    <div className="form-group">
                        <label htmlFor="title">Title</label>
                        <input type="text" name="title" id="title" placeholder="Enter book title" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="genres">Genres</label>
                        <input type="text" name="genres" id="genres"
                               placeholder="Enter genres for the book. Put a comma between them" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="description">Description</label>
                        <input type="text" name="description" id="description" placeholder="Enter book description" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="image">Image URL</label>
                        <input type="text" name="image" id="image" placeholder="Enter book image URL" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="author">Author</label>
                        <input type="text" name="author" id="author" placeholder="Enter book author" onChange={onFormChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="number" name="price" id="price" placeholder="Enter book price" onChange={onFormChange}/>
                    </div>
                    <input type="submit" value="Create"/>
                </form>
            </div>
        );
    }
}

export default Form(CreateBook);