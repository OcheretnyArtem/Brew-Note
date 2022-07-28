package by.data.remote

import com.google.firebase.firestore.FirebaseFirestore

class TestFireStore(
    private val fireStore: FirebaseFirestore
) {

    fun test() {
        fireStore.collection("users").add(
            User(
                "artsiom",
                "Some Photo"
            )
        )
    }

    data class User(
        val name: String,
        val photoURL: String
    )
}
