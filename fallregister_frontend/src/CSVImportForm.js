
import React from 'react';

import {FormLabel, Input, Grid} from '@material-ui/core/';

class CSVImportForm extends React.Component {
    render(){

        return(
            <form action="/action_page.php">
            <Grid
        container
        direction='column'
        justify="center"
            //alignItems='flex-start'
            >

            <Grid>
            <h>CVS Import</h>
            </Grid>

            <Grid>
            <FormLabel for="lname">CSV Dokument hochladen: </FormLabel>
            <Input type="file" id="csvFile" name="csvFile"></Input>

            </Grid>

            <Input type="submit" value="Submit"></Input>
            </Grid>
            </form>
    );
    }
}

export default CSVImportForm;