package nl.nekoconeko.glaciercmd.types;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class VaultInventory {
	public String VaultARN;
	public Date InventoryDate;
	public List<Archive> ArchiveList;

	public static VaultInventory loadFromJSON(String json) throws IOException {
		ObjectMapper map = new ObjectMapper();
		map.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		VaultInventory inv = map.readValue(json, VaultInventory.class);
		return inv;
	}

	public static VaultInventory loadFromJSON(File file) throws IOException {
		ObjectMapper map = new ObjectMapper();
		map.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		VaultInventory inv = map.readValue(file, VaultInventory.class);
		return inv;
	}

	public static class Archive {
		public String ArchiveId;
		public String ArchiveDescription;
		public Date CreationDate;
		public int Size;
		public String SHA256TreeHash;

		@Override
		public String toString() {
			return String.format("Archive [ArchiveId=%s, ArchiveDescription=%s, CreationDate=%s, Size=%s, SHA256TreeHash=%s]", ArchiveId, ArchiveDescription, CreationDate, Size, SHA256TreeHash);
		}
	}

	@Override
	public String toString() {
		return String.format("VaultInventory [VaultARN=%s, InventoryDate=%s, ArchiveList=%s]", VaultARN, InventoryDate, ArchiveList);
	}
}
