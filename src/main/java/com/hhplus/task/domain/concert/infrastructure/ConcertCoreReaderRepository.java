package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.models.ConcertEntity;
import com.hhplus.task.domain.concert.repositories.ConcertReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class ConcertCoreReaderRepository implements ConcertReaderRepository {

    private ConcertJpaRepository concertJpaRepository;
    private ConcertApplyHistoryQuerydslRepository concertApplyHistoryQuerydslRepository;

    @Override
    public Concert findById(Long id) {
        Optional<ConcertEntity> concertEntity = concertJpaRepository.findById(id);

        return concertEntity.isPresent() ? concertEntity.get().toConcert() : null;
    }

    @Override
    public List<Concert> findAll() {
        return concertJpaRepository.findAll()
                .stream()
                .map(ConcertEntity::toConcert)
                .toList();
    }

    @Override
    public List<Concert> findAllAbailable() {
        // 콘서트 신청 기록에서 만든 <콘서트 아이디, 신경 개수>
        Map<Long,Long> concertIdCount = concertApplyHistoryQuerydslRepository.findAllConcertIdAndCount();

        return concertJpaRepository.findAll().stream()
                .filter(concert -> concert.getCapacity() < concertIdCount.get(concert.getId()))
                .map(ConcertEntity::toConcert)
                .toList();
    }

    /**
     * 콘서트
     *
     * @param id
     * @return
     */
    @Override
    public boolean isAbailableById(Long id) {
        return concertJpaRepository.findById(id).orElseThrow().getCapacity()
                < concertApplyHistoryQuerydslRepository.countByConcertId(id);
    }
}
