<template>
  <div id="app">
    <div class="row padding-big primary vertical-center">
      <h1>Ticket-scan</h1>
    </div>
    <div class="row margin space-between">
      <a class="button secondary" @click="active = 'all'">All tickets</a>
      <a class="button secondary" @click="active = 'add'">Add tickets</a>
      <a class="button secondary" @click="active = 'scan'">Scan tickets</a>
    </div>

    <ts-tickets v-if="active == 'all'" :ticketService="ticketService"></ts-tickets>
    <ts-add v-if="active == 'add'" :ticketService="ticketService"></ts-add>
    <ts-scan v-if="active == 'scan'" :ticketService="ticketService"></ts-scan>

  </div>
</template>

<script>
import { TicketService } from './TicketService';

import TicketsComponent  from './components/TicketsComponent';
import AddComponent  from './components/AddComponent';
import ScanComponent from './components/ScanComponent';

export default {
  name: 'app',
  components: {
    "ts-tickets" : TicketsComponent,
    "ts-add" : AddComponent,
    "ts-scan" : ScanComponent
  },
  data () {
    return {
      ticketService: new TicketService("http://localhost:8080"),
      active: 'all'
    }
  }
}
</script>

<style>
@import url('./assets/jackfruit.min.css');
</style>
