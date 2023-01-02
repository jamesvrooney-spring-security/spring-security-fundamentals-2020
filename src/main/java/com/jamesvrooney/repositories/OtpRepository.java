package com.jamesvrooney.repositories;

import com.jamesvrooney.entities.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
}
