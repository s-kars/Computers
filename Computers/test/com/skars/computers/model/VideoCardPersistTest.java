package com.skars.computers.model;

import com.skars.computers.model.video.GraphicsMemory;
import com.skars.computers.model.video.VideoCard;
import com.skars.computers.model.video.VideoCardSocket;

public class VideoCardPersistTest extends GenericPersistTest<VideoCard> {

	@Override
	public VideoCard constructsDetail() {
		VideoCard videoCard = new VideoCard("Palit GForce 440", "Palit");
		videoCard.setMemoryType(GraphicsMemory.GDDR5);
		videoCard.setMemoryVolume(1024);
		videoCard.setProcessorManufacturer("NVidia");
		videoCard.setSocket(VideoCardSocket.PCI_EXPRESS_x16_20);
		
		return videoCard;
	}

	@Override
	public Class<VideoCard> getDetailClass() {
		return VideoCard.class;
	}
}
