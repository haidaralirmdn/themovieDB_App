package com.app.filmindonesia.di;


import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.data.local.LocalRepository;
import com.app.filmindonesia.data.remote.RemoteRepository;

public class Injection {
    public static PublicRepository provideRepository() {
        LocalRepository localRepository = new LocalRepository();
        RemoteRepository remoteRepository = RemoteRepository.getInstance();

        return PublicRepository.getInstance(localRepository, remoteRepository);
    }
}
