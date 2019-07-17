import React from 'react';
import Button from '@material-ui/core/Button'
import {AddVetForm} from "./AddVetForm";
import specialityService from "../services/SpecialityService";

export class AddVet extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isFormVisible: false,
            specialities: []
        };
        this.showForm = this.showForm.bind(this);
    }

    showForm() {
        this.setState({isFormVisible: true});
    }

    render() {
        let form = "";
        if(this.state.isFormVisible){
            form = <AddVetForm specialities = {this.state.specialities} />
        }
        return <React.Fragment>
            <Button variant="contained" onClick={this.showForm}>Add Vet</Button>
            {form}
        </React.Fragment>
    }

    componentWillMount() {
        specialityService.getSpecialities()
            .then(res => {
                this.setState({
                    specialities: res
                });
            });
    }
}
