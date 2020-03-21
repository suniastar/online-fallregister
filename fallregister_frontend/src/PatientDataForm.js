
import React from 'react';

import {InputLabel,FormLabel,FormControlLabel, Input, Grid, Checkbox, Button, Divider} from '@material-ui/core/';

class PatientDataForm extends React.Component {
    constructor(){
        super();
        this.onSubmit = this.onSubmit.bind(this);
    }
    onSubmit(event){
        event.preventDefault();
        const json = {
            patient: {
                firstname: document.getElementById("patientFirstName"),
                name: document.getElementById("patientLastName"),
                address:{
                    street : document.getElementById("patientFirstName"),
                    housenumber: document.getElementById("patientFirstName"),
                    zipcode: document.getElementById("patientFirstName"),
                    city:document.getElementById("patientFirstName"),
                    country:document.getElementById("patientFirstName"),
                },
                birthday: document.getElementById("patientBirthday"),
                sex: document.getElementById("patientFirstName"),
                phone: document.getElementById("patientPhone"),
                email: document.getElementById("patientEmail")
            },
            detector: {
                firstname: document.getElementById("patientFirstName"),
                name: document.getElementById("patientFirstName"),
                address:{
                    street : document.getElementById("patientFirstName"),
                    housenumber: document.getElementById("patientFirstName"),
                    zipcode: document.getElementById("patientFirstName"),
                    city:document.getElementById("patientFirstName"),
                    country:document.getElementById("patientFirstName"),
                },
                phone: document.getElementById("patientFirstName"),
                email: document.getElementById("patientFirstName")
            },
            diagnosis:{
                suspected: document.getElementById("suspected"),
                diagnosed: document.getElementById("diagnosed"),
                dead: document.getElementById("death"),
                dateOfSickness: document.getElementById("dayOfInfection"),
                dateOfDiagnosis: document.getElementById("dayOfDiagnose"),
                dateOfDeath: document.getElementById("dayOfDeath")
            },
            jobs:{
                medical: document.getElementById("medical"),
                food: document.getElementById("food"),
                communal: document.getElementById("epiCommunal"),
            },
            accommodation:{
                communal:document.getElementById("accCommunal"),
                hospital: document.getElementById("hospital"),
                dateOfHospitalisation: document.getElementById("dateOfHospitalisation"),
                icu: document.getElementById("patientFirstName"),
                dateOfIcu: document.getElementById("patientFirstName"),
                nameAndAddress: document.getElementById("addressAndPlace"),
            },
            gesundheitsamt: {
                name: document.getElementById("patientFirstName"),
                address:{
                    street : document.getElementById("patientFirstName"),
                    housenumber: document.getElementById("patientFirstName"),
                    zipcode: document.getElementById("patientFirstName"),
                    city:document.getElementById("patientFirstName"),
                    country:document.getElementById("patientFirstName"),
                },
                phone: document.getElementById("patientFirstName"),
                email: document.getElementById("patientFirstName"),
            },
            laboratory: {
                commission: document.getElementById("patientFirstName"),
                name: document.getElementById("patientFirstName"),
                address:{
                    street : document.getElementById("patientFirstName"),
                    housenumber: document.getElementById("patientFirstName"),
                    zipcode: document.getElementById("patientFirstName"),
                    city:document.getElementById("patientFirstName"),
                    country:document.getElementById("patientFirstName"),
                },
                phone: document.getElementById("patientFirstName"),
                dateOfBiopsy: document.getElementById("patientFirstName")
            }
        }
        console.log( json)
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
        <div class="horizontalDivider"></div>
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
                                <Input type="text" id="patientFirstName" name="fname" ref="myFirstname"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="lname">Nachname:</FormLabel>
                                <Input type="text" id="patientLastName" name="lname"></Input>
                            </Grid>

                            <Grid container
                                  direction= "row"
                                  item
                            >
                                <Grid xs={5}>
                                    <FormLabel for="address">Strasse:</FormLabel>
                                    <Input type="text" id="address" name="address"></Input>
                                </Grid>

                                <Grid xs={7}>
                                    <FormLabel for="address">Hausnummer:</FormLabel>
                                    <Input type="text" id="address" name="address"></Input>
                                </Grid>

                            </Grid>
                            <Grid container
                                  direction= "row"
                                  item
                            >
                                <Grid xs={5}>
                                    <FormLabel for="address">PLZ:</FormLabel>
                                    <Input type="text" id="address" name="address"></Input>
                                </Grid>

                                <Grid xs={7}>
                                    <FormLabel for="address">Stadt:</FormLabel>
                                    <Input type="text" id="address" name="address"></Input>
                                </Grid>

                            </Grid>
                            <Grid>
                                <FormLabel for="address">Land:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>



                            <Grid>
                                <FormLabel for="birthday">Geburtsdatum:</FormLabel>
                                <Input type="date" id="patientBirthday" name="birthday"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="gender">Geschlecht:</FormLabel>
                                <FormControlLabel control = {<Checkbox/>} label = "weiblich" />
                                <FormControlLabel control = {<Checkbox/>} label = "männlich" />
                                <FormControlLabel control = {<Checkbox/>} label = "divers" />
                            </Grid>

                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="patientPhone" name="telephonenumber"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="email" id="patientEmail" name="email"></Input>
                            </Grid>
                        </Grid>
                        <div class="verticalDivider"></div>
                        <Grid container
                              direction='column'
                              item
                              xs={5}
                        >


                            <Grid container
                                  direction='column'
                            >
                                <Grid>
                                    <FormControlLabel control = {<Checkbox id="suspected"/>} label = "Verdacht" />
                                </Grid>
                                <Grid>
                                    <FormControlLabel control = {<Checkbox id="diagnosed" />} label = "Klinische Diagnose" />
                                </Grid>
                                <Grid>
                                    <FormControlLabel control = {<Checkbox id="death" />} label = "Tod" />
                                </Grid>
                                <Grid>
                                    <FormLabel for="fname">Todesdatum:</FormLabel>
                                    <Input type="date" id="dayOfDeath" name="dayOfDeath"id="dateOfDeath"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfInfection">Erkrankungsbeginn:</FormLabel>
                                    <Input type="date" id="dayOfInfection" name="dayOfInfection"id="dateOfSickness"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfDiagnose">Diagnosedatum:</FormLabel>
                                    <Input type="date" id="dayOfDiagnose" name="dayOfDiagnose"id="dateOfDiagnosis"></Input>
                                </Grid>
                            </Grid>


                        </Grid>

                    </Grid>

            <div class="horizontalDivider"></div>
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
                                <FormControlLabel control = {<Checkbox id="medical" />} label = "Patient/in ist im medizinischen Bereich tätig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="food"/>} label = "Patient/in ist im Lebensmittelbereich tätig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="epiCommunal"/>} label = "Patient/in ist in Gemeinschaftseinrichtung tätig,  z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkünfte" />
                            </Grid>

                            <Grid>
                                <FormControlLabel control = {<Checkbox id="accCommunal"/>} label = "Patient/in wird in Gemeinschaftseinrichtung betreut, z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkünfte" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="hospital" />} label = "Patient/in ist in Krankenhaus/Pflegeeinrichtung seit:" />
                                <Input type="date" id="dateOfcare" name="dateOfcare" id="dateOfHospitalisation" ></Input>
                            </Grid>
                            <Grid>
                            <FormLabel for="stay">Name und Ort der Einrichtung</FormLabel>
                            <Input type="text" id="stay" name="stay" id="addressAndPlace"></Input>
                            </Grid>
                        </Grid>

                    </Grid>
                    <div className="horizontalDivider"></div>
                    <Grid container
                          direction='column'
                          justify='flex-start'
                          alignItems="stretch"

                    >
                        <Grid>
                            <FormLabel class="big">Angaben zur wahrscheinlichen Infektionsquelle:</FormLabel>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionPlace">Wahrscheinlicher Infektionsort:</FormLabel>
                            <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionSource">Wahrscheinlicher Infektionsquelle:</FormLabel>
                            <Input type="text" id="infectionSource" name="infectionSource"></Input>
                        </Grid>
                        <Grid>
                            <FormControlLabel control = {<Checkbox/>} label = "Meldung ist Teil einer Erkrankungshäufung:" />
                            <FormLabel for="infectionSource"> Ausbruchsort, vermutete Exposition, etc.:</FormLabel>
                            <Input type="text" id="infectionExposition" name="infectionSource"></Input>
                        </Grid>
                    </Grid>
            <div class="horizontalDivider"></div>
                    <Grid container
                          direction='row'
                          justify='flex-start'
                          alignItems="stretch"
                    >
                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"
                              xs={4}
                              item
                        >
                            <Grid>
                                <FormLabel class="big">Unverzueglich zu melden an:</FormLabel>
                            </Grid>
                            <Grid>
                                <FormLabel for="fname">Gesundheitsamt:</FormLabel>
                                <Input type="text" id="fname" name="fname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Strasse:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Hausnummer:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">PLZ:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Stadt:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="email" id="email" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="labor">Untersuchungsstelle:</FormLabel>
                                <Input type="text" id="labor" name="labor"></Input>
                            </Grid>
                        </Grid>
                        <div class="verticalDivider"></div>
                        <Grid container
                              direction='column'
                              xs={4}
                              item
                        >
                            <Grid>
                                <FormControlLabel control = {<Checkbox/>} label = "Es wurde ein Labor/eine Untersuchungsstelle mit der Erregerdiagnostik beauftragt." />
                            </Grid>
                            <Grid>
                                <FormLabel for="labname"> Labor Name:</FormLabel>
                                <Input type="text" id="labname" name="labname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="lablocation"> Labor Ort:</FormLabel>
                                <Input type="text" id="lablocation" name="lablocation"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="labphone"> Labor Telefonnummer:</FormLabel>
                                <Input type="text" id="labphone" name="labphone"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="probedate"> Probenentnahme am:</FormLabel>
                                <Input type="text" id="probedate" name="probedate"></Input>
                            </Grid>
                        </Grid>
                        <div class="verticalDivider"></div>
                        <Grid container
                              direction='column'
                              justify='flex-start'
                              alignItems="stretch"
                              xs={3}
                              item
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
                                <FormLabel for="address">Strasse:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Hausnummer:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">PLZ:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Stadt:</FormLabel>
                                <Input type="text" id="address" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email:</FormLabel>
                                <Input type="email" id="email" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer:</FormLabel>
                                <Input type="tel" id="telephonenumber" name="telephonenumber"></Input>
                            </Grid>
                        </Grid>
                    </Grid>
            <div class="horizontalDivider"></div>

                    <div class="submitButton">
                        <Button type="submit" value="Submit" variant="contained" color="primary" >Daten einreichen</Button>
                    </div>

                </Grid>
        </Grid>
            </form>
        );
    }
}

export default PatientDataForm;