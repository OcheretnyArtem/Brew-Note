package by.data.remote.utils

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

internal inline fun <reified T : RemoteData> observeItemsFromFireStore(
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
        dbRef.addSnapshotListener(listener)
    }

    awaitClose {
        dbRef.addSnapshotListener(listener).remove()
    }

}.flowOn(coroutineContext)

internal inline fun <reified T : RemoteData> observeItemFromFireStore(
    dbRef: DocumentReference,
    coroutineContext: CoroutineContext,
    ): Flow<T> = callbackFlow {

    val listener =
        EventListener<DocumentSnapshot> { value, _ ->
            value?.toObject<T>()?.let {
                this@callbackFlow.trySend(it)
            }
        }

    dbRef.addSnapshotListener(listener)

    awaitClose {
        dbRef.addSnapshotListener(listener).remove()
    }

}.flowOn(coroutineContext)
