import React from 'react';
//import './App.css';
import './App_light.css';
import {Button} from '@material-ui/core/';
import PatientDataForm from "./PatientDataForm.js"
import CSVImportForm from './CSVImportForm.js';
import LoginForm from "./LoginForm"
import {  withCookies, Cookies  } from 'react-cookie';
import { instanceOf } from 'prop-types';

import {FormLabel, Input, Grid} from '@material-ui/core/';

import DataView from "./DataView"

class App extends React.Component {
    static propTypes = {
        cookies: instanceOf(Cookies).isRequired
      };

    constructor(props){
        super(props);
        this.state = {buttontext: "manual"};
        this.goToManual = this.goToManual.bind(this);
        this.goToCsvImport = this.goToCsvImport.bind(this);
        this.goToView = this.goToView.bind(this);
        this.verifySession = this.verifySession.bind(this);
        this.onLogin = this.onLogin.bind(this);
        this.onLogout = this.onLogout.bind(this);
    }

    goToManual(){
        this.setState({buttontext: "manual"});
        }

    goToCsvImport(){
        this.setState({buttontext: "csvimport"});
    }

    goToView(){
        this.setState({buttontext: "view"});
    }
    verifySession(){
        const { cookies } = this.props;
        return cookies.get("token");
    }
    onLogin(){
        const { cookies } = this.props;
        return cookies.set("token");
    }
    onLogout(){
        const { cookies } = this.props;
        return cookies.remove("token");
    }

    render(){
        let form= <h>oh oh</h>;
        if(/*true|| */ this.verifySession()){
        if(this.state.buttontext === "manual"){
            form = <PatientDataForm />;
        }else if(this.state.buttontext === "csvimport") {
            form = <CSVImportForm/>;
        }else if(this.state.buttontext === "view") {
            form = <DataView/>;
        }
        }else{
            form =             <form onSubmit={this.onLogin}>
            <Grid container direction='column' justify="center">
                <Grid>
                <FormLabel for="user">Benutzername:</FormLabel>
                <Input required type="text" id="fname" name="fname"></Input>
                </Grid>

                <Grid>
                <FormLabel for="password">Password:</FormLabel>
                <Input required type="password" id="lname" name="lname"></Input>
                </Grid>

                <Grid>
                    <Button type="submit" value="Submit" variant="contained" color="primary" m={2}>Login</Button>
                </Grid>

            </Grid>
            </form>
        }


        return (
            <div id="App">
                <header className="App-header">
                    <div class='alignleft'>
                        <Button onClick={this.goToManual} color="primary"
                            variant={this.state.buttontext === "manual" ? "contained" : ""}>Manueller Input</Button>
                    </div>
                    <div class='alignleft'>
                    <Button onClick={this.goToCsvImport} color="primary"
                        variant={this.state.buttontext === "csvimport" ? "contained" : ""}>CSV Import</Button>
                    </div>
                    <div class='alignleft'>
                    <Button onClick={this.goToView} color="primary"
                        variant={this.state.buttontext === "view" ? "contained" : ""}>Datenansicht</Button>
                    </div>
                    <div class='alignright'>
                        <Button onClick={this.onLogout}>Logout</Button>
                    </div>
                </header>
                <div class='App-main'>
                    {form}
                </div>
            </div>
        );
    }
    
}

export default withCookies(App);
