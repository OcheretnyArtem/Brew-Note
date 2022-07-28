package by.data.remoteData

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

internal inline fun <reified T : RemoteData> observeFromFireStore(
    dbRef: CollectionReference,
    coroutineContext: CoroutineContext,
    keySearchQuery: String? = null,
    valueSearchQuery: Any? = null,
): Flow<List<T>> = callbackFlow {

    val listener =
        EventListener<QuerySnapshot> { value, _ ->
            value?.toObjects<T>()?.let {
                this@callbackFlow.trySend(it)
            }
        }
    if (keySearchQuery != null && valueSearchQuery != null) {
        dbRef.whereEqualTo(keySearchQuery, valueSearchQuery).addSnapshotListener(listener)
    } else {
        dbRef.addSnapshotListener(listener).remove()
    }

    awaitClose {

    }

}.flowOn(coroutineContext)