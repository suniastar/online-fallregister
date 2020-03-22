
import React from 'react';

import {FormLabel, Input, Grid, Button} from '@material-ui/core/';

class CSVImportForm extends React.Component {
    render(){

        return(
            <form action="/action_page.php">
                <Grid container direction='column' justify="center">

                    <Grid>
                        <FormLabel for="testDataView">Es funktioniert!: </FormLabel>
                        <Input type="text" id="testView" name="testView"></Input>
                    </Grid>

                </Grid>
            </form>
        );
    }
}

export default CSVImportForm;