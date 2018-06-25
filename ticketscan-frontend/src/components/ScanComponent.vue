<template>
    <div class="margin-big">

        <div class="row padding">
            <h2>Scan tickets</h2>
        </div>

        <qr-reader></qr-reader>

    </div>
</template>

<script>
import { QrcodeReader } from 'vue-qrcode-reader';

export default {
    components: {
        'qr-reader' : QrcodeReader
    }
}
</script>

<style>

</style>


