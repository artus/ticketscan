<template>
    <div class="margin-big">

        <div class="row padding">
            <h2>Scan tickets</h2>
        </div>

        <qr-reader @decode="scanTicket"></qr-reader>

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
    methods: {
        scanTicket(id) {
            this.ticketService.scanTicket(id, function() { alert("Scanned!")});
        }
    }
}
</script>

<style>

</style>


