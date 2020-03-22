
import React from 'react';

import {InputLabel,FormLabel,FormControlLabel, Input, Grid, Checkbox, Button, Divider} from '@material-ui/core/';

class PatientDataForm extends React.Component {
    constructor(){
        super();
        this.onSubmit = this.onSubmit.bind(this);
    }
    onSubmit(event){
        event.preventDefault();
        let sex = document.getElementById("sexMale").checked ? "male" : "";
        sex = document.getElementById("sexFemale").checked ? "female" : sex;
        sex = document.getElementById("sexDivers").checked ? "divers" : sex;
        const json = {
            patient: {
                firstname: document.getElementById("patientFirstName").value,
                name: document.getElementById("patientLastName").value,
                address:{
                    street : document.getElementById("patientStreet").value,
                    housenumber: document.getElementById("patientHouse").value,
                    zipcode: document.getElementById("patientZip").value,
                    city:document.getElementById("patientCity").value,
                    country:document.getElementById("patientCountry").value,
                },
                birthday: document.getElementById("patientBirthday").value,
                sex: sex,
                phone: document.getElementById("patientPhone").value,
                email: document.getElementById("patientEmail").value
            },
            detector: {
                firstname: document.getElementById("mFname").value,
                name: document.getElementById("mName").value,
                address:{
                    street : document.getElementById("mStreet").value,
                    housenumber: document.getElementById("mHousenumber").value,
                    zipcode: document.getElementById("mZip").value,
                    city:document.getElementById("mCity").value,
                },
                phone: document.getElementById("mPhone").value,
                email: document.getElementById("mMail").value
            },
            diagnosis:{
                suspected: document.getElementById("suspected").checked,
                diagnosed: document.getElementById("diagnosed").checked,
                dead: document.getElementById("death").checked,
                dateOfSickness: document.getElementById("dayOfInfection").value,
                dateOfDiagnosis: document.getElementById("dayOfDiagnose").value,
                dateOfDeath: document.getElementById("dayOfDeath").value
            },
            jobs:{
                medical: document.getElementById("medical").checked,
                food: document.getElementById("food").checked,
                communal: document.getElementById("epiCommunal").checked,
            },
            infection:{
                place: document.getElementById("infectionPlace").value,
                source:  document.getElementById("infectionPlace").value,
                epidemi:  document.getElementById("epidemi").checked,
                epidemiSource: document.getElementById("infectionExposition").value
            },
            accommodation:{
                communal:document.getElementById("accCommunal").checked,
                hospital: document.getElementById("hospital").checked,
                dateOfHospitalisation: document.getElementById("dateOfHospitalisation").value,
                icu: document.getElementById("patientFirstName").checked,
                dateOfIcu: document.getElementById("patientFirstName").value,
                nameAndAddress: document.getElementById("addressAndPlace").value,
            },
            gesundheitsamt: {
                name: document.getElementById("gName").value,
                address:{
                    street : document.getElementById("gStreet").value,
                    housenumber: document.getElementById("gHousenumber").value,
                    zipcode: document.getElementById("gZip").value,
                    city:document.getElementById("gCity").value,
                },
                phone: document.getElementById("gPhone").value,
                email: document.getElementById("gMail").value,
                untersuchungsstelle: document.getElementById("gStelle").value,
            },
            laboratory: {
                commission: document.getElementById("commission").checked,
                name: document.getElementById("labname").value,
                location: document.getElementById("lablocation").value,
                phone: document.getElementById("labphone").value,
                dateOfBiopsy: document.getElementById("probedate").value
            }
        }
        fetch('localhost:8080/endpoint/', {
         method: 'POST',
         headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(json)
        })
        .then(res => res.json())
        .then(
          (result) => {
            alert("Erfolgreich gespeichert")
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
            alert("fehler" + error)
          }
        )
    }
    render(){

 return(
    <form onSubmit={this.onSubmit}>
    <Grid
          container
          direction='column'
          justify="center"
          alignItems='stretch'

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
            <FormLabel class= "big">Meldepflichtige Krankheit gemäß §§6,8,9 IfSG (Spezialfall Corona)</FormLabel>
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
                                <FormLabel for="fname">Vorname: </FormLabel>
                                <Input required type="text" id="patientFirstName" name="fname" ref="myFirstname"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="lname">Nachname: </FormLabel>
                                <Input required type="text" id="patientLastName" name="lname"></Input>
                            </Grid>

                            <Grid container
                                  direction= "row"
                                  item
                            >
                                <Grid xs={5}>
                                    <FormLabel for="address">Strasse: </FormLabel>
                                    <Input type="text" id="patientStreet" name="address"></Input>
                                </Grid>

                                <Grid xs={7}>
                                    <FormLabel for="address">Hausnummer: </FormLabel>
                                    <Input type="text" id="patientHouse" name="address"></Input>
                                </Grid>

                            </Grid>
                            <Grid container
                                  direction= "row"
                                  item
                            >
                                <Grid xs={5}>
                                    <FormLabel for="address">PLZ: </FormLabel>
                                    <Input type="text" id="patientZip" name="address"></Input>
                                </Grid>

                                <Grid xs={7}>
                                    <FormLabel for="address">Stadt: </FormLabel>
                                    <Input type="text" id="patientCity" name="address"></Input>
                                </Grid>

                            </Grid>
                            <Grid>
                                <FormLabel for="address">Land: </FormLabel>
                                <Input type="text" id="patientCountry" name="address"></Input>
                            </Grid>



                            <Grid>
                                <FormLabel for="birthday">Geburtsdatum: </FormLabel>
                                <Input required type="date" id="patientBirthday" name="birthday"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="gender">Geschlecht: </FormLabel>
                                <FormControlLabel control = {<Checkbox id="sexFemale"/>} label = "weiblich" />
                                <FormControlLabel control = {<Checkbox id="sexMale"/>} label = "männlich" />
                                <FormControlLabel control = {<Checkbox id="sexDivers"/>} label = "divers" />
                            </Grid>

                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer: </FormLabel>
                                <Input type="tel" id="patientPhone" name="telephonenumber"></Input>
                            </Grid>

                            <Grid>
                                <FormLabel for="email">Email: </FormLabel>
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
                                    <FormLabel for="fname">Todesdatum: </FormLabel>
                                    <Input type="date" id="dayOfDeath" name="dayOfDeath"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfInfection">Erkrankungsbeginn: </FormLabel>
                                    <Input type="date" id="dayOfInfection" name="dayOfInfection"></Input>
                                </Grid>
                                <Grid>
                                    <FormLabel for="dayOfDiagnose">Diagnosedatum: </FormLabel>
                                    <Input type="date" id="dayOfDiagnose" name="dayOfDiagnose"></Input>
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
                                <FormLabel class="big">Epidemiologische Situation: </FormLabel>
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="medical" />} label = "Patient/in ist im medizinischen Bereich taetig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="food"/>} label = "Patient/in ist im Lebensmittelbereich taetig" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="epiCommunal"/>} label = "Patient/in ist in Gemeinschaftseinrichtung taetig,  z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkuenfte" />
                            </Grid>

                            <Grid>
                                <FormControlLabel control = {<Checkbox id="accCommunal"/>} label = "Patient/in wird in Gemeinschaftseinrichtung betreut, z.B. Schule, Kinderkrippe, Heim, sonst. Massenunterkuenfte" />
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="hospital" />} label = "Patient/in ist in Krankenhaus/Pflegeeinrichtung seit: " />
                                <Input type="date" id="dateOfcare" name="dateOfcare" id="dateOfHospitalisation" ></Input>
                            </Grid>
                            <Grid>
                                <FormControlLabel control = {<Checkbox id = "intensiveCare" />} label = "Patient/in ist auf der Intensivstation seit: "/>
                                <Input type="date" id="dateOfIntensiveCare"></Input>
                            </Grid>
                            <Grid>
                            <FormLabel for="stay">Name und Ort der Einrichtung: </FormLabel>
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
                            <FormLabel class="big">Angaben zur wahrscheinlichen Infektionsquelle: </FormLabel>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionPlace">Wahrscheinlicher Infektionsort: </FormLabel>
                            <Input type="text" id="infectionPlace" name="infectionPlace"></Input>
                        </Grid>
                        <Grid>
                            <FormLabel for="infectionSource">Wahrscheinlicher Infektionsquelle: </FormLabel>
                            <Input type="text" id="infectionSource" name="infectionSource"></Input>
                        </Grid>
                        <Grid>
                            <FormControlLabel control = {<Checkbox id="epidemi"/>} label = "Meldung ist Teil einer Erkrankungshäufung:" />
                            <FormLabel for="infectionSource"> Ausbruchsort, vermutete Exposition, etc.: </FormLabel>
                            <Input type="text" id="infectionExposition" name="epidemiSource"></Input>
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
                                <FormLabel class="big">Unverzueglich zu melden an: </FormLabel>
                            </Grid>
                            <Grid>
                                <FormLabel for="fname">Gesundheitsamt: </FormLabel>
                                <Input required type="text" id="gName" name="fname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Strasse: </FormLabel>
                                <Input type="text" id="gStreet" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Hausnummer: </FormLabel>
                                <Input type="text" id="gHousenumber" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">PLZ: </FormLabel>
                                <Input type="text" id="gZip" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Stadt: </FormLabel>
                                <Input type="text" id="gCity" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer: </FormLabel>
                                <Input type="tel" id="gPhone" name="telephonenumber"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email: </FormLabel>
                                <Input type="email" id="gMail" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="labor">Untersuchungsstelle: </FormLabel>
                                <Input type="text" id="gStelle" name="labor"></Input>
                            </Grid>
                        </Grid>
                        <div class="verticalDivider"></div>
                        <Grid container
                              direction='column'
                              xs={4}
                              item
                        >
                            <Grid>
                                <FormControlLabel control = {<Checkbox id="commission"/>} label = "Es wurde ein Labor/eine Untersuchungsstelle mit der Erregerdiagnostik beauftragt." />
                            </Grid>
                            <Grid>
                                <FormLabel for="labname"> Labor Name: </FormLabel>
                                <Input type="text" id="labname" name="labname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="lablocation"> Labor Ort: </FormLabel>
                                <Input type="text" id="lablocation" name="lablocation"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="labphone"> Labor Telefonnummer: </FormLabel>
                                <Input type="text" id="labphone" name="labphone"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="probedate"> Probenentnahme am: </FormLabel>
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
                                <FormLabel for="fname">Vorname: </FormLabel>
                                <Input type="text" id="mFname" name="fname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="lname">Nachname: </FormLabel>
                                <Input type="text" id="mName" name="lname"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Strasse: </FormLabel>
                                <Input type="text" id="mStreet" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Hausnummer: </FormLabel>
                                <Input type="text" id="mHousenumber" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">PLZ: </FormLabel>
                                <Input type="text" id="mZip" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="address">Stadt: </FormLabel>
                                <Input type="text" id="mCity" name="address"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="email">Email: </FormLabel>
                                <Input type="email" id="mMail" name="email"></Input>
                            </Grid>
                            <Grid>
                                <FormLabel for="telephonenumber">Telefonnummer: </FormLabel>
                                <Input type="tel" id="mPhone" name="telephonenumber"></Input>
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