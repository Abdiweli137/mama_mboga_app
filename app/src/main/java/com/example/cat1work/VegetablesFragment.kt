package com.example.cat1work

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VegetablesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vegetables, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewVegetables)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val produceList = listOf(
            Vegetable(
                id = 1,
                name = "Sukuma Wiki (Kale)",
                category = "Vegetable",
                price = "KSh 20 / bunch",
                imageResId = R.drawable.sukuma,
                description = "Freshly harvested organic green sukuma wiki. Rich in vitamins A, C, and K, fiber, and calcium. Perfect for traditional meals and healthy vegetable stir-fry."
            ),
            Vegetable(
                id = 2,
                name = "Fresh Cabbage",
                category = "Vegetable",
                price = "KSh 60 / head",
                imageResId = R.drawable.cabbage,
                description = "Crisp, sweet, and tightly packed fresh green cabbage. Excellent for salad, coleslaw, steaming, and soups."
            ),
            Vegetable(
                id = 3,
                name = "Sweet Bananas",
                category = "Fruit",
                price = "KSh 100 / dozen",
                imageResId = R.drawable.bananas,
                description = "Sweet and delicious naturally ripened yellow bananas. Rich in potassium, fiber, and instant natural energy."
            ),
            Vegetable(
                id = 4,
                name = "Juicy Lemons",
                category = "Fruit",
                price = "KSh 10 / piece",
                imageResId = R.drawable.lemon,
                description = "Tangy, juicy lemons rich in Vitamin C and antioxidants. Perfect for refreshing lemonade, tea, detox drinks, and salad dressing."
            ),
            Vegetable(
                id = 5,
                name = "Crisp Red Apples",
                category = "Fruit",
                price = "KSh 40 / piece",
                imageResId = R.drawable.apple,
                description = "Crisp, crunchy, and naturally sweet red apples. High in fiber and Vitamin C for a healthy daily lifestyle."
            )
        )

        val adapter = VegetablesAdapter(produceList) { vegetable ->
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra("EXTRA_VEGETABLE", vegetable)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}