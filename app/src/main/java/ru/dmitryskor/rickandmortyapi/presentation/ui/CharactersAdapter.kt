package ru.dmitryskor.rickandmortyapi.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.dmitryskor.rickandmortyapi.databinding.ItemCharacterBinding
import ru.dmitryskor.rickandmortyapi.presentation.model.CharacterUIEntity

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
class CharactersAdapter : PagingDataAdapter<CharacterUIEntity, CharacterVH>(CharacterDiffCallBack()) {
    override fun onBindViewHolder(holder: CharacterVH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterVH {
        return CharacterVH(parent)
    }
}

class CharacterVH (
    parent: ViewGroup,
    private val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CharacterUIEntity?) {
        binding.characterName.text = item?.name
    }
}

class CharacterDiffCallBack : DiffUtil.ItemCallback<CharacterUIEntity>() {
    override fun areItemsTheSame(oldItem: CharacterUIEntity, newItem: CharacterUIEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharacterUIEntity,
        newItem: CharacterUIEntity
    ): Boolean {
        return oldItem == newItem
    }

}