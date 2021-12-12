package talk.push.faceter.module.nearby

import android.content.Context
import com.google.android.gms.nearby.Nearby
import com.google.android.gms.nearby.connection.*

class Advertising(
    private val context: Context,
    private val mPayloadCallback : PayloadCallback
) {
    private val connectionsClient: ConnectionsClient by lazy{
        Nearby.getConnectionsClient(context)
    }
    private var endpointNameAdvertising = ""
    private var endpointNameDiscovery = ""

    fun startAdvertising(
        endpointNameAdvertising: String,
        endpointNameDiscovery: String
    ) {
        this.endpointNameAdvertising = endpointNameAdvertising
        this.endpointNameDiscovery = endpointNameDiscovery
        val advertisingOptions  = AdvertisingOptions.Builder()
            .setDisruptiveUpgrade(false)//false, если пользователю необходимо поддерживать подключение к Интернету
            .setStrategy(STRATEGY_NEARBY).build()
        connectionsClient
            .startAdvertising(
                endpointNameAdvertising, SERVICE_ID , mConnectionLifecycleCallback, advertisingOptions
            )
    }

    private val mConnectionLifecycleCallback = object : ConnectionLifecycleCallback(){
        override fun onConnectionInitiated(endPointId: String, p1: ConnectionInfo) {
            if (endPointId == endpointNameDiscovery)
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