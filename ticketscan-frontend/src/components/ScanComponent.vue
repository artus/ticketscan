<template>
    <div class="margin-big">

        <div class="row padding">
            <h2>Scan tickets</h2>
        </div>

        <div v-if="scanning">
            <qr-reader @decode="scanTicket"></qr-reader>
        </div>

    </div>
</template>

<script>
import { QrcodeReader } from 'vue-qrcode-reader';

export default {
    props: {
        ticketService : {
            type: Object,
            required: true,
        }
    },
    components: {
        'qr-reader' : QrcodeReader
    },
    data() {
        return {
            scanning: true 
        }
    },
    methods: {
        scanTicket(id) {
            this.scanning = false;
            console.log("Scanning " + id);
            this.ticketService.scanTicket(id, function() { alert("Scanned!")});
            setTimeout((function(){ this.scanning = true }).bind(this), 1000);
        }
    }
}
</script>

<style>

</style>


