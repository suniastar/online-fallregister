
import React from 'react';

import {InputLabel,FormLabel,FormControlLabel, Input, Grid, Checkbox, Button} from '@material-ui/core/';

class PatientDataForm extends React.Component {
    constructor(){
        super();
        this.onSubmit = this.onSubmit.bind(this);
        this.input = {
            patient: {
                firstname: "",
                name: "",
                address:{
                    street : "",
                    housenumber: "",
                    zipcode: 0,
                    city:"",
                    country:"",
                },                            
                birthday: "",
                sex: "",
                phone: "",
                email: ""
            },
            detector: {
                firstname: "",
                name: "",
                address:{
                    street : "",
                    housenumber: "",
                    zipcode: 0,
                    city:"",
                    country:"",
                },                            
                phone: "",
                email: ""
            },
            diagnosis:{
                suspected: false,
                diagnosed: false,
                dead: false,
                dateOfSickness: "",
                dateOfDiagnosis: "",
                dateOfDeath: ""
            },
            jobs:{
                medical: false,
                food: false,
                communal: false,
            },
            accommodation:{
                communal:false,
                hospital: false,
                dateOfHospitalisation: "",
                icu: false,
                dateOfIcu: ""
            },
            gesundheitsamt: {
                name: "",
                address:{
                    street : "",
                    housenumber: "",
                    zipcode: 0,
                    city:"",
                    country:"",
                },                            
                phone: "",
                email: "",
            },
            laboratory: {
                commission: false,
                name: "",
                address:{
                    street : "",
                    housenumber: "",
                    zipcode: 0,
                    city:"",
                    country:"",
                },                            
                phone: "",
                dateOfBiopsy: ""
            } 
        }
    }
    onSubmit(){
        alert("Tadaaaaaaa!");
    }
    render(){

 return(
    <form onSubmit={this.onSubmit}>
    <Grid
          container
          direction='column'
          justify="center"
          alignItems='flex-start'

                >

        <Grid>
            <Grid container
                  direction= 'row'
                  justify= 'space-between'
            >
                <Grid>
                    <FormLabel class="big">Meldeformular</FormLabel>
                </Grid>
                <Grid>
                    -Vertraulich-
                </Grid>
            </Grid>
            <FormLabel class= "big">Meldepflichtige Krankheit gemäß §§6,8,9 IfSG</FormLabel>
        </Grid>

        <Grid container
              direction= 'row'
              justify= 'flex-start'
              alignItems= "stretch"
        >
                    <Grid container
                          direction='row'
                          justify='flex-start'
                          alignItems="stretch"
                    >

                        <Grid container
                              direction='column'
                              item
                              xs={6}
                        >
                            <Grid>
                                <FormLabel class="big">Patientendaten </FormLabel>
                            </Grid>

                            <Grid>
                                <FormLabel for="fname">Vorname:</FormLabel>
                                <Input type="text" id="fname" name="fname"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="lname">Nachname:</FormLabel>
                                <Input type="text" id="lname" name="lname"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="address">Adresse:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="birthday">Geburtsdatum:</FormLabel>
                                <Input type="date" id="birthday" name="birthday"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="gender">Geschlecht:</FormLabel>
                                <FormControlLabel control = {<Checkbox/>} label = "weiblich" />
                                <FormControlLabel control = {<Checkbox/>} label = "männlich" />
                                <FormControlLabel control = {<Checkbox/>} label = "divers" />
                            </Grid>

                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="email" id="email" name="email"></Input>
                            </Grid>
                        </Grid>
                        <Grid container
                              direction='column'
                              item
                              xs={6}
                        >


                            <Grid container
                                  direction='column'
                            >
                                <Grid>
                                    <FormControlLabel control = {<Checkbox/>} label = "Verdacht" />
                                </Grid>
                                <Grid>
                                    <FormControlLabel control = {<Checkbox/>} label = "Klinische Diagnose" />
                                </Grid>
                                <Grid>
                                    <FormControlLabel control = {<Checkbox/>} label = "Tod" />
                                </Grid>
                                <Grid>
                                    <FormLabel for="fname">Todesdatum:</FormLabel>
                                    <Input type="date" id="dayOfDeath" name="dayOfDeath"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfInfection">Erkrankungsbeginn:</FormLabel>
                                    <Input type="date" id="dayOfInfection" name="dayOfInfection"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfDiagnose">Diagnosedatum:</FormLabel>
                                    <Input type="date" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfDeath">Datum der Meldung:</FormLabel>
                                    <Input type="date" id="dayOfReport" name="dayOfReport"></Input>
                                </Grid>
                            </Grid>


                        </Grid>

                    </Grid>


                    <Grid container
                          direction='row'
                          justify='flex-start'
                          alignItems="stretch"
                    >


                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"
                              xs={9}
                        >
                            <Grid>
                                <FormLabel class="big">Epidemiologische Situation:</FormLabel>
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Patient/in ist im medizinischen Bereich tätig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Patient/in ist im Lebensmittelbereich tätig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Patient/in ist in Gemeinschaftseinrichtung tätig, z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkünfte" />
                            </Grid>

                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Patient/in wird betreut Gemeinschaftseinrichtung tätig, z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkünfte" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Patient/in ist in Krankenhaus/stationärer Pflegeeinrichtung seit" />
                                <Input type="date" id="dateOfcare" name="dateOfcare"></Input>
                            </Grid>
                        </Grid>
                        <Grid xs={3}>
                            <FormLabel for="stay">Ort der Einrichtung</FormLabel>
                            <Input type="text" id="stay" name="stay"></Input>
                        </Grid>

                    </Grid>

                    <Grid container
                          direction='column'
                          justify='flex-start'
                          alignItems="stretch"

                    >
                        <Grid>
                            <FormLabel class="big">Angaben zur wahrscheinlichen Infektionsquelle:</FormLabel>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionPlace">Wahrscheinlicher Infektionsort</FormLabel>
                            <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionSource">Wahrscheinlicher Infektionsquelle:</FormLabel>
                            <Input type="text" id="infectionSource" name="infectionSource"></Input>
                        </Grid>
                        <Grid>
                            <FormControlLabel control = {<Checkbox/>} label = "Meldung ist Teil einer Erkrankungshäufung:" />
                            <FormLabel for="infectionSource"> Ausbruchsort, vermutete Exposition, etc.:</FormLabel>
                            <Input type="text" id="infectionSource" name="infectionSource"></Input>
                        </Grid>
                    </Grid>

                    <Grid container
                          direction='row'
                          justify='flex-start'
                          alignItems="stretch"
                    >
                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"
                              xs={6}
                        >
                            <Grid>
                                <FormLabel class="big">Unverzueglich zu melden an:</FormLabel>
                            </Grid>
                            <Grid>
                                <FormLabel for="fname">Vorname:</FormLabel>
                                <Input type="text" id="fname" name="fname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="lname">Nachname:</FormLabel>
                                <Input type="text" id="lname" name="lname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="date" id="email" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="labor">Untersuchungsstelle:</FormLabel>
                                <Input type="text" id="labor" name="labor"></Input>
                            </Grid>
                        </Grid>


                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"
                              xs={6}
                        >
                            <Grid>
                                <FormLabel class="big">Melder</FormLabel>
                            </Grid>
                            <Grid>
                                <FormLabel for="fname">Vorname:</FormLabel>
                                <Input type="text" id="fname" name="fname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="lname">Nachname:</FormLabel>
                                <Input type="text" id="lname" name="lname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Anschrift:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="text" id="email" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonnumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="telephonnumber" name="telephonenumber"></Input>
                            </Grid>
                        </Grid>
                    </Grid>

                    <Grid>
                    <Button type="submit" value="Submit" variant="contained" color="primary" >Daten einreichen</Button>
                    </Grid>

                </Grid>
        </Grid>
            </form>
        );
    }
}

export default PatientDataForm;