import React from 'react';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import FormControlLabel from '@material-ui/core/FormControlLabel';

import './add-vet.css';

export class AddVetForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            specialities: []
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSelectChange = this.handleSelectChange.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSelectChange() {
        console.log('handling');
    }

    render() {
        return <div className="add-vet-form">
            <TextField
                required
                id="standard-required"
                label="First Name"
                value={this.state.firstName}
                onChange={this.handleChange}
                margin="normal"
                name="firstName"
            />

            <TextField
                required
                id="standard-required"
                label="Last Name"
                value={this.state.lastName}
                onChange={this.handleChange}
                name="lastName"
                margin="normal"
            />
            <div className="speciality-multi-select">
                <InputLabel htmlFor="select-multiple">Speciality</InputLabel>
                {
                    this.props.specialities.map(s => <FormControlLabel key={s.id}
                            control={
                                <Checkbox key={s.id} value={s.checked}/>
                            }
                            label={s.name}
                        />
                    )}
            </div>
            <div className="add-vet-form__footer">
                <Button variant="contained">Cancel</Button>
                <Button variant="contained">Add</Button>
            </div>
        </div>;
    }
}
