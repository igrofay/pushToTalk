package talk.push.faceter.module.nearby

import android.content.Context
import com.google.android.gms.nearby.Nearby
import com.google.android.gms.nearby.connection.*

class Discovery(
    private val context: Context,
    private val mPayloadCallback : PayloadCallback,
){

    private val connectionsClient: ConnectionsClient by lazy{
        Nearby.getConnectionsClient(context)
    }
    private var endpointNameAdvertising = ""
    private var endpointNameDiscovery = ""
    fun startDiscovery(
        endpointNameAdvertising: String,
        endpointNameDiscovery: String
    ){
        this.endpointNameAdvertising = endpointNameAdvertising
        this.endpointNameDiscovery = endpointNameDiscovery
        val discoveryOptions = DiscoveryOptions.Builder()
            .setStrategy(STRATEGY_NEARBY).build()
        connectionsClient
            .startDiscovery(SERVICE_ID, mEndpointDiscoveryCallback, discoveryOptions)

    }
    private val mEndpointDiscoveryCallback = object : EndpointDiscoveryCallback(){
        override fun onEndpointFound(
            endpointId: String,
            p1: DiscoveredEndpointInfo
        ) {
            if (endpointId == endpointNameAdvertising)
                connectionsClient
                    .requestConnection(endpointNameDiscovery , endpointId, mConnectionLifecycleCallback)
        }

        override fun onEndpointLost(p0: String) {
            //TODO если хостер пропал
        }

    }
    private val mConnectionLifecycleCallback = object : ConnectionLifecycleCallback(){
        override fun onConnectionInitiated(endPointId: String, p1: ConnectionInfo) {
            connectionsClient.acceptConnection(endPointId, mPayloadCallback )
        }

        override fun onConnectionResult(p0: String, resul : ConnectionResolution) {
            when(resul.status.statusCode){
                ConnectionsStatusCodes.STATUS_OK -> {

                }
                ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED ->{
                    // Соединение было отклонено одной или обеими сторонами.
                }
                ConnectionsStatusCodes.STATUS_ERROR->{
                    //Соединение прервалось до того, как его удалось принять.
                }
            }
        }

        override fun onDisconnected(p0: String) {
            //Мы были отключены от этой конечной точки. Больше никакие данные не могут быть отправлены или получены.
        }

    }
}